package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

import jp.ga.fw.common.util.ClassPath;
import jp.ga.fw.common.util.GeneticUtils;
import jp.ga.fw.core.Crossable;
import jp.ga.fw.core.Initializable;
import jp.ga.fw.core.Mutationable;
import jp.ga.fw.core.Phaseable;
import jp.ga.fw.core.Selectionable;
import jp.ga.fw.definition.DomManager;
import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * FWメインフロークラス
 * 
 * @author nori
 *
 */
public class RunGeneticAlgorithms {
	
	//個体郡
	private List<Individual> individuals = new ArrayList<>();
	
	//設定
	private GaConfigValues config = GaConfigValues.getInstance();
	
	/**
	 * メイン実行メソッド
	 * エントリーポイントから呼び出される。
	 * 
	 * @param args
	 */
	public void run(String[] args) {
		try {
			//初期化
			init(args);
			//メイン処理
			mainLoop(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初期化メソッド
	 * 
	 * @param args
	 * @throws Exception
	 */
	private void init(String[] args) throws Exception {
		
		Random rand = new Random();
		DomManager dm = new DomManager();
		
		//設定情報をロード
		dm.load(args[0]);
		
		//ロードされた設定情報から初期化クラスパス(String)を取得
		String classPathStr = config.getClassPathInit();
		
		//初期化クラスパス(String)からインスタンスを生成
		Initializable init = new ClassPath<Initializable>().createInstance(classPathStr);
		
		//初期化メソッドを実行し、返ってきた評価関数を各個体に格納する
		//格納時、各個体はランダムな値を評価関数により計算し成績として保持する
		//TODO:初期値入力の乱数の種類を設定する事を検討する必要あり
		Function <Double, Double> func = init.init();
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(rand.nextInt()));
			individuals.add(ind);
		}
		
	}
	
	/**
	 * メインの処理
	 * @param args
	 * @throws Exception
	 */
	private void mainLoop(String[] args) throws Exception {
		
		String selectionClassPath = config.getClassPathSelection();
		String crossOverClassPath = config.getClassPathCrossOver();
		String mutationClassPath = config.getClassPathMutation();
		
		//選択（淘汰）クラスパスからインスタンスを生成
		Selectionable selection = new ClassPath<Selectionable>().createInstance(selectionClassPath);
		Crossable crossOver = new ClassPath<Crossable>().createInstance(crossOverClassPath);
		Mutationable mutation = new ClassPath<Mutationable>().createInstance(mutationClassPath);
		
		//発生確率を取得
		Double incidenceSelection = config.getIncidenceSelection();
		Double incidenceCrossOver = config.getIncidenceCrossOver();
		Double incidenceMutation = config.getIncidenceMutation();
		
		//インスタンスと発生確率をマップ化(フェーズの順序は保障されるべきなのでLinkedHashMapとする)
		Map<Phaseable, Double> phaseMap = new LinkedHashMap<>();
		phaseMap.put(selection, incidenceSelection);
		phaseMap.put(crossOver, incidenceCrossOver);
		phaseMap.put(mutation, incidenceMutation);
		
		//TODO：一旦無限ループで実装
		while (true) {
			//各フェーズのインスタンスを取得
			for(Phaseable phase : phaseMap.keySet()) {
				if(GeneticUtils.occurrence(phaseMap.get(phase))) phase.execute();
			}
			Thread.sleep((long) 0.1);
		}
		
	}
	
	
	
}

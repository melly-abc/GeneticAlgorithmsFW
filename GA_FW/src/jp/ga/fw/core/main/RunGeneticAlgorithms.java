package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import jp.ga.fw.core.Initializable;
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初期化メソッド
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
		Class<?> initClass = Class.forName(classPathStr);
		Initializable init = (Initializable) initClass.getConstructor().newInstance();
		
		//初期化メソッドを実行し、返ってきた評価関数を各個体に格納する
		//格納時、各個体はランダムな値を評価関数により計算し成績として保持する
		//TODO:初期値入力の乱数の種類を設定する事を検討する必要あり
		Function <Double, Double> func = init.init();
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(rand.nextInt()));
			individuals.add(ind);
		}
		
	}
}

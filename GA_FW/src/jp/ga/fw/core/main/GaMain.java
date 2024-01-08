package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * フレームワークエントリーポイント
 * 
 * @author nori
 *
 */
public class GaMain {
	//個体郡
	private List<Individual> individuals = new ArrayList<>();
	//設定
	private GaConfigValues config = GaConfigValues.getInstance();
	
	
	public void main(String[] args) throws Exception {
		
		//TODO 仮置き
		config.setNum(5);
		
		this.init();
		
		while (true) {
			//
		}
	}
	
	private void init() {
		//TODO 仮置き
		Function <Double, Double> func = x -> x*x;
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(i));
			individuals.add(ind);
		}
	}
	
}

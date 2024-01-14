package jp.ga.fw.core.main;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jp.ga.fw.core.Initializable;
import jp.ga.fw.definition.DomManager;
import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * フレームワークエントリーポイント
 * 
 * @author nori
 *
 */
public class GaMain {
	
	public static void main(String[] args) throws Exception {
		RunGeneticAlgorithms ga = new RunGeneticAlgorithms();
		// FWメインロジック実行
		ga.run(args);
	}
	
}

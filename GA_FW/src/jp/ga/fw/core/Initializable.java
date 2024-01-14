package jp.ga.fw.core;

import java.util.function.Function;


/**
 * 初期処理インターフェース
 * 
 * @author nori
 */
public interface Initializable{
	/**
	 * 初期処理抽象メソッド
	 * 
	 * 個体が持つ成績を評価する評価関数を返すこと
	 * @return 評価関数
	 */
	public Function<Double, Double> init();
}

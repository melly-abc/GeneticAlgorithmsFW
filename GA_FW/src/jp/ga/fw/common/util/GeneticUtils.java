package jp.ga.fw.common.util;

/**
 * 遺伝的ユーティリティクラス
 * 
 * @author nori
 *
 */
public class GeneticUtils {
	/**
	 * 発生メソッド
	 * 
	 * 引数で指定された発生率（パーセント）でTrueを返す
	 * @param parcent　発生率（パーセント）
	 * @return 発生結果
	 */
	public static boolean occurrence(double parcent) {
		double d = Math.random();
		if(d < parcent / 100){
			return true;
		}
		return false;
	}	
}

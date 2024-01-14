package jp.ga.fw.core;


/**
 * フェーズインターフェース
 * 各フェーズの大本となるインターフェース
 * @author nori
 */
public interface Phaseable {
	/**
	 * 実行処理抽象メソッド
	 * 
	 * @return 評価関数
	 */
	public void execute();
}

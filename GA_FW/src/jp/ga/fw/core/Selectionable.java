package jp.ga.fw.core;


/**
 * 選択（淘汰）処理インターフェース
 * 
 * @author nori
 */
public interface Selectionable extends Phaseable{
	/**
	 * 実行処理抽象メソッド
	 * 
	 */
	public void execute();
}

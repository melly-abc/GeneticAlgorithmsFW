package ga.pseudo.cross;

import jp.ga.fw.core.Crossable;

/**
 * 交叉クラス
 * 
 * 交叉実行時に呼び出されるクラス。
 * クラス名は任意だが、Crossableインターフェースを実装すること。
 * 
 * @author nori
 *
 */
public class CrossOver implements Crossable {

	/**
	 * 実行メソッド
	 * 交叉ロジックを実装する。
	 */

	@Override
	public void execute() {
		System.out.println("Cross");

	}

}
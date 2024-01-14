package ga.pseudo.selection;

import jp.ga.fw.core.Selectionable;

/**
 * 選択（淘汰）クラス
 * 
 * 選択（淘汰）実行時に呼び出されるクラス。
 * クラス名は任意だが、Selectionableインターフェースを実装すること。
 * 
 * @author nori
 *
 */
public class Selection implements Selectionable {

	/**
	 * 実行メソッド
	 * 選択（淘汰）ロジックを実装する。
	 */

	@Override
	public void execute() {
		System.out.println("Selection");

	}

}

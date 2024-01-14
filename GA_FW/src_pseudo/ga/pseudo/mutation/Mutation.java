package ga.pseudo.mutation;

import jp.ga.fw.core.Mutationable;

/**
 * 突然変異クラス
 * 
 * 突然変異実行時に呼び出されるクラス。
 * クラス名は任意だが、Mutationableインターフェースを実装すること。
 * 
 * @author nori
 *
 */
public class Mutation implements Mutationable{

	/**
	 * 実行メソッド
	 * 突然変異ロジックを実装する。
	 */

	@Override
	public void execute() {
		System.out.println("Mutation");

	}


}

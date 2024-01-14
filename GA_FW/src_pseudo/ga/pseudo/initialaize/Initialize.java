package ga.pseudo.initialaize;

import java.util.function.Function;

import jp.ga.fw.core.Initializable;


/**
 * 初期化クラス
 * アルゴリズム実行前に呼び出されるクラス。
 * クラス名は任意だが、Initializableインターフェースを実装すること。
 * @author nori
 *
 */
public class Initialize implements Initializable{

   /**
    * 初期化メソッド
	* 個体が持つ評価関数を定義して返す必要がある。
    * return 評価関数
    */
	@Override
	public Function<Double, Double> init() {
		System.out.println("INIT");
		//E.G. 二次方程式の解を評価関数とする
		Function <Double, Double> func = x -> x*x;
		return func;
	}

}

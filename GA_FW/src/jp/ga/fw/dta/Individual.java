package jp.ga.fw.dta;

import java.util.function.Function;

/**
 * 個体DTAクラス
 * @author nori
 *
 */
public class Individual {
	//個体が保持する値（成績）
	private Double value = null;
	//個体の評価関数
	private Function<Double, Double> evaluationFunc = null;
	
	public Individual(Function<Double, Double> func){
		evaluationFunc = func;
	}
	
	public Individual(Function<Double, Double> func, Double val){
		evaluationFunc = func;
		calc(val);
	}
	
	public void calc(Double val) {
		this.value = this.evaluationFunc.apply(val);
	}
	
	public Double getValue() {
		return this.value;
	}
}

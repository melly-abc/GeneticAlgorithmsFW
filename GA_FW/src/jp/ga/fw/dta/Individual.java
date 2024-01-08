package jp.ga.fw.dta;

import java.util.function.Function;

/**
 * ��DTA�N���X
 * @author nori
 *
 */
public class Individual {
	//�̂��ێ�����l�i���сj
	private Double value = null;
	//�̂̕]���֐�
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

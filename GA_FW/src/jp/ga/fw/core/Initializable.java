package jp.ga.fw.core;

import java.util.function.Function;


/**
 * ���������C���^�[�t�F�[�X
 * 
 * @author nori
 */
public interface Initializable{
	/**
	 * �����������ۃ��\�b�h
	 * 
	 * �̂������т�]������]���֐���Ԃ�����
	 * @return �]���֐�
	 */
	public Function<Double, Double> init();
}

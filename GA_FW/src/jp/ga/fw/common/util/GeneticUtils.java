package jp.ga.fw.common.util;

/**
 * ��`�I���[�e�B���e�B�N���X
 * 
 * @author nori
 *
 */
public class GeneticUtils {
	/**
	 * �������\�b�h
	 * 
	 * �����Ŏw�肳�ꂽ�������i�p�[�Z���g�j��True��Ԃ�
	 * @param parcent�@�������i�p�[�Z���g�j
	 * @return ��������
	 */
	public static boolean occurrence(double parcent) {
		double d = Math.random();
		if(d < parcent / 100){
			return true;
		}
		return false;
	}	
}

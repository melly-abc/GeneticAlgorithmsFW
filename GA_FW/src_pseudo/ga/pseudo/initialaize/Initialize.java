package ga.pseudo.initialaize;

import java.util.function.Function;

import jp.ga.fw.core.Initializable;


/**
 * �������N���X
 * �A���S���Y�����s�O�ɌĂяo�����N���X�B
 * �N���X���͔C�ӂ����AInitializable�C���^�[�t�F�[�X���������邱�ƁB
 * @author nori
 *
 */
public class Initialize implements Initializable{

   /**
    * ���������\�b�h
	* �̂����]���֐����`���ĕԂ��K�v������B
    * return �]���֐�
    */
	@Override
	public Function<Double, Double> init() {
		System.out.println("INIT");
		//E.G. �񎟕������̉���]���֐��Ƃ���
		Function <Double, Double> func = x -> x*x;
		return func;
	}

}

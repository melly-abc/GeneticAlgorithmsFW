package ga.pseudo.cross;

import jp.ga.fw.core.Crossable;

/**
 * �����N���X
 * 
 * �������s���ɌĂяo�����N���X�B
 * �N���X���͔C�ӂ����ACrossable�C���^�[�t�F�[�X���������邱�ƁB
 * 
 * @author nori
 *
 */
public class CrossOver implements Crossable {

	/**
	 * ���s���\�b�h
	 * �������W�b�N����������B
	 */

	@Override
	public void execute() {
		System.out.println("Cross");

	}

}
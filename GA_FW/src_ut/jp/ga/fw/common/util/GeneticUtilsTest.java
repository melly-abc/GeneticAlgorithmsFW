package jp.ga.fw.common.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * ��`�I���[�e�B���e�B�N���X�e�X�g
 * 
 * @author nori
 *
 */
public class GeneticUtilsTest {
	
	/**
	 * �������\�b�h�e�X�g01
	 * ���Ғl�@������100�p�[�Z���g���w�肵�A�K��True���Ԃ��Ă��邱��
	 */
	@Test
	public void testCase01(){
		assertTrue(GeneticUtils.occurrence(100));
	}

	/**
	 * �������\�b�h�e�X�g02
	 * ���Ғl�@������0�p�[�Z���g���w�肵�A�K��False���Ԃ��Ă��邱��
	 */
	@Test
	public void testCase02(){
		assertTrue(!GeneticUtils.occurrence(0));
	}
	

	
}

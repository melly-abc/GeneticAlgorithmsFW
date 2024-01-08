package jp.ga.fw.dta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

/**
 * �t���[�����[�N��`DTA�e�X�g
 * @author nori
 *
 */
public class GaConfigValuesTest {
	
	/**
	 * �t�@�N�g���[���\�b�h�e�X�g01
	 * ���Ғl�@GaConfigValues�̃C���X�^���X���Ԃ��Ă��邱��
	 */
	@Test
	public void testCase01(){
		GaConfigValues gaConfig = GaConfigValues.getInstance();
		assertTrue(gaConfig instanceof GaConfigValues);
	}
	
	/**
	 * �t�@�N�g���[���\�b�h�e�X�g02
	 * ���Ғl�@���getInstance()�����s���A�Ԃ��Ă����C���X�^���X������̂��̂ł��邱��
	 */
	@Test
	public void testCase02(){
		GaConfigValues gaConfig1 = GaConfigValues.getInstance();
		GaConfigValues gaConfig2 = GaConfigValues.getInstance();
		assertTrue(gaConfig1 == gaConfig2);
	}
	
	/**
	 * �A�N�Z�T�e�X�g01
	 * ���Ғl�@�SGetter����NULL���Ԃ��Ă��邱��
	 */
	@Test
	public void testCase03(){
		Integer expInt = 0;
		GaConfigValues gaConfig = GaConfigValues.getInstance();
		assertTrue(Objects.isNull(gaConfig.getIncidenceCrossOver()));
		assertTrue(Objects.isNull(gaConfig.getIncidenceMutation()));
		assertEquals(expInt, gaConfig.getNum());
	}
	
	/**
	 * �A�N�Z�T�e�X�g02
	 * ���Ғl�@�SGetter����Setter�Ŋi�[�����l���Ԃ��Ă��邱��
	 */
	@Test
	public void testCase04(){
		GaConfigValues gaConfig = GaConfigValues.getInstance();
		Double exp = 1.0;
		Integer expInt = 1;
		gaConfig.setIncidenceCrossOver(exp);
		gaConfig.setIncidenceMutation(exp);
		gaConfig.setNum(1);
		assertEquals(exp, gaConfig.getIncidenceCrossOver());
		assertEquals(exp, gaConfig.getIncidenceMutation());
		assertEquals(expInt, gaConfig.getNum());
	}
	
}

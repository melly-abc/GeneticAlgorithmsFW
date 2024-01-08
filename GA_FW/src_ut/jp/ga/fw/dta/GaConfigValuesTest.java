package jp.ga.fw.dta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

/**
 * フレームワーク定義DTAテスト
 * @author nori
 *
 */
public class GaConfigValuesTest {
	
	/**
	 * ファクトリーメソッドテスト01
	 * 期待値　GaConfigValuesのインスタンスが返ってくること
	 */
	@Test
	public void testCase01(){
		GaConfigValues gaConfig = GaConfigValues.getInstance();
		assertTrue(gaConfig instanceof GaConfigValues);
	}
	
	/**
	 * ファクトリーメソッドテスト02
	 * 期待値　二回getInstance()を実行し、返ってきたインスタンスが同一のものであること
	 */
	@Test
	public void testCase02(){
		GaConfigValues gaConfig1 = GaConfigValues.getInstance();
		GaConfigValues gaConfig2 = GaConfigValues.getInstance();
		assertTrue(gaConfig1 == gaConfig2);
	}
	
	/**
	 * アクセサテスト01
	 * 期待値　全GetterからNULLが返ってくること
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
	 * アクセサテスト02
	 * 期待値　全GetterからSetterで格納した値が返ってくること
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

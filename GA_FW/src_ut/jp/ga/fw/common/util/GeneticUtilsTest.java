package jp.ga.fw.common.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * 遺伝的ユーティリティクラステスト
 * 
 * @author nori
 *
 */
public class GeneticUtilsTest {
	
	/**
	 * 発生メソッドテスト01
	 * 期待値　引数に100パーセントを指定し、必ずTrueが返ってくること
	 */
	@Test
	public void testCase01(){
		assertTrue(GeneticUtils.occurrence(100));
	}

	/**
	 * 発生メソッドテスト02
	 * 期待値　引数に0パーセントを指定し、必ずFalseが返ってくること
	 */
	@Test
	public void testCase02(){
		assertTrue(!GeneticUtils.occurrence(0));
	}
	

	
}

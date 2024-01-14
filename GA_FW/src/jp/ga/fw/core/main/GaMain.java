package jp.ga.fw.core.main;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jp.ga.fw.core.Initializable;
import jp.ga.fw.definition.DomManager;
import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * �t���[�����[�N�G���g���[�|�C���g
 * 
 * @author nori
 *
 */
public class GaMain {
	
	public static void main(String[] args) throws Exception {
		RunGeneticAlgorithms ga = new RunGeneticAlgorithms();
		// FW���C�����W�b�N���s
		ga.run(args);
	}
	
}

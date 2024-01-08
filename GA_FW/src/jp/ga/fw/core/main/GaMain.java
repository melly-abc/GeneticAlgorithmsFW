package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * �t���[�����[�N�G���g���[�|�C���g
 * 
 * @author nori
 *
 */
public class GaMain {
	//�̌S
	private List<Individual> individuals = new ArrayList<>();
	//�ݒ�
	private GaConfigValues config = GaConfigValues.getInstance();
	
	
	public void main(String[] args) throws Exception {
		
		//TODO ���u��
		config.setNum(5);
		
		this.init();
		
		while (true) {
			//
		}
	}
	
	private void init() {
		//TODO ���u��
		Function <Double, Double> func = x -> x*x;
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(i));
			individuals.add(ind);
		}
	}
	
}

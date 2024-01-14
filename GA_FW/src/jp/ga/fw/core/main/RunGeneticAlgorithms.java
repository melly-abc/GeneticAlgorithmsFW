package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import jp.ga.fw.core.Initializable;
import jp.ga.fw.definition.DomManager;
import jp.ga.fw.dta.GaConfigValues;
import jp.ga.fw.dta.Individual;

/**
 * FW���C���t���[�N���X
 * 
 * @author nori
 *
 */
public class RunGeneticAlgorithms {
	
	//�̌S
	private List<Individual> individuals = new ArrayList<>();
	
	//�ݒ�
	private GaConfigValues config = GaConfigValues.getInstance();
	
	/**
	 * ���C�����s���\�b�h
	 * �G���g���[�|�C���g����Ăяo�����B
	 * 
	 * @param args
	 */
	public void run(String[] args) {
		try {
			//������
			init(args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���������\�b�h
	 * @param args
	 * @throws Exception
	 */
	private void init(String[] args) throws Exception {
		Random rand = new Random();
		DomManager dm = new DomManager();
		
		//�ݒ�������[�h
		dm.load(args[0]);
		
		//���[�h���ꂽ�ݒ��񂩂珉�����N���X�p�X(String)���擾
		String classPathStr = config.getClassPathInit();
		
		//�������N���X�p�X(String)����C���X�^���X�𐶐�
		Class<?> initClass = Class.forName(classPathStr);
		Initializable init = (Initializable) initClass.getConstructor().newInstance();
		
		//���������\�b�h�����s���A�Ԃ��Ă����]���֐����e�̂Ɋi�[����
		//�i�[���A�e�̂̓����_���Ȓl��]���֐��ɂ��v�Z�����тƂ��ĕێ�����
		//TODO:�����l���̗͂����̎�ނ�ݒ肷�鎖����������K�v����
		Function <Double, Double> func = init.init();
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(rand.nextInt()));
			individuals.add(ind);
		}
		
	}
}

package jp.ga.fw.core.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

import jp.ga.fw.common.util.ClassPath;
import jp.ga.fw.common.util.GeneticUtils;
import jp.ga.fw.core.Crossable;
import jp.ga.fw.core.Initializable;
import jp.ga.fw.core.Mutationable;
import jp.ga.fw.core.Phaseable;
import jp.ga.fw.core.Selectionable;
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
			//���C������
			mainLoop(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���������\�b�h
	 * 
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
		Initializable init = new ClassPath<Initializable>().createInstance(classPathStr);
		
		//���������\�b�h�����s���A�Ԃ��Ă����]���֐����e�̂Ɋi�[����
		//�i�[���A�e�̂̓����_���Ȓl��]���֐��ɂ��v�Z�����тƂ��ĕێ�����
		//TODO:�����l���̗͂����̎�ނ�ݒ肷�鎖����������K�v����
		Function <Double, Double> func = init.init();
		for (int i = 0; i < config.getNum(); i++) {
			Individual ind = new Individual(func, Double.valueOf(rand.nextInt()));
			individuals.add(ind);
		}
		
	}
	
	/**
	 * ���C���̏���
	 * @param args
	 * @throws Exception
	 */
	private void mainLoop(String[] args) throws Exception {
		
		String selectionClassPath = config.getClassPathSelection();
		String crossOverClassPath = config.getClassPathCrossOver();
		String mutationClassPath = config.getClassPathMutation();
		
		//�I���i�����j�N���X�p�X����C���X�^���X�𐶐�
		Selectionable selection = new ClassPath<Selectionable>().createInstance(selectionClassPath);
		Crossable crossOver = new ClassPath<Crossable>().createInstance(crossOverClassPath);
		Mutationable mutation = new ClassPath<Mutationable>().createInstance(mutationClassPath);
		
		//�����m�����擾
		Double incidenceSelection = config.getIncidenceSelection();
		Double incidenceCrossOver = config.getIncidenceCrossOver();
		Double incidenceMutation = config.getIncidenceMutation();
		
		//�C���X�^���X�Ɣ����m�����}�b�v��(�t�F�[�Y�̏����͕ۏႳ���ׂ��Ȃ̂�LinkedHashMap�Ƃ���)
		Map<Phaseable, Double> phaseMap = new LinkedHashMap<>();
		phaseMap.put(selection, incidenceSelection);
		phaseMap.put(crossOver, incidenceCrossOver);
		phaseMap.put(mutation, incidenceMutation);
		
		//TODO�F��U�������[�v�Ŏ���
		while (true) {
			//�e�t�F�[�Y�̃C���X�^���X���擾
			for(Phaseable phase : phaseMap.keySet()) {
				if(GeneticUtils.occurrence(phaseMap.get(phase))) phase.execute();
			}
			Thread.sleep((long) 0.1);
		}
		
	}
	
	
	
}

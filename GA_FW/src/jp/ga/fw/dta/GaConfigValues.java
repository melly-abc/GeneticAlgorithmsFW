package jp.ga.fw.dta;

import java.util.Objects;


/**
 * �t���[�����[�N��`DTA
 * @author nori
 *
 */
public class GaConfigValues {
	
	private static GaConfigValues instance = null;
	//�I���i�����j������
	private Double incidenceSelection = null;
	//����������
	private Double incidenceCrossOver = null;
	//�ˑR�ψٔ�����
	private Double incidenceMutation = null;
	//�I���i�����j�N���X
	private String classPathSelection = null;
	//�����N���X
	private String classPathCrossOver = null;
	public String getClassPathInit() {
		return classPathInit;
	}

	public void setClassPathInit(String classPathInit) {
		this.classPathInit = classPathInit;
	}

	//�ˑR�ψكN���X
	private String classPathMutation = null;
	//���������N���X
	private String classPathInit = null;
	
	public String getClassPathSelection() {
		return classPathSelection;
	}

	public void setClassPathSelection(String classPathSelection) {
		this.classPathSelection = classPathSelection;
	}

	public String getClassPathCrossOver() {
		return classPathCrossOver;
	}

	public void setClassPathCrossOver(String classPathCrossOver) {
		this.classPathCrossOver = classPathCrossOver;
	}

	public String getClassPathMutation() {
		return classPathMutation;
	}

	public void setClassPathMutation(String classPathMutation) {
		this.classPathMutation = classPathMutation;
	}

	//�̐�
	private Integer num = 0;
	
	private GaConfigValues() {}
	
	/**
	 * GaConfigValues Factory�@Method
	 * @return
	 */
	public static GaConfigValues getInstance() {
		if(Objects.isNull(instance)) instance = new GaConfigValues();
		return instance;
	}
	
	/**
	 * ����������Getter
	 * @return ����������
	 */
	public Double getIncidenceCrossOver() {
		return incidenceCrossOver;
	}
	
	/**
	 * ����������Setter
	 * @param incidenceCrossOver ����������
	 */
	public void setIncidenceCrossOver(Double incidenceCrossOver) {
		this.incidenceCrossOver = incidenceCrossOver;
	}
	
	/**
	 * �ˑR�ψٔ�����Getter
	 * @return �ˑR�ψٔ�����
	 */
	public Double getIncidenceMutation() {
		return incidenceMutation;
	}
	
	/**
	 * �ˑR�ψٔ�����Setter
	 * @param incidenceMutation �ˑR�ψٔ�����
	 */
	public void setIncidenceMutation(Double incidenceMutation) {
		this.incidenceMutation = incidenceMutation;
	}
	
	/**
	 * �̐�Getter
	 * @return�@�̐�
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * �̐�Setter
	 * @param num�@�̐�
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getIncidenceSelection() {
		return incidenceSelection;
	}

	public void setIncidenceSelection(Double incidenceSelection) {
		this.incidenceSelection = incidenceSelection;
	}

	
	
}

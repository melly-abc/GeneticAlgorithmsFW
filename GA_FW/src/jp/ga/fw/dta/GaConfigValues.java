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

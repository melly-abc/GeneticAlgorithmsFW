package jp.ga.fw.dta;

import java.util.Objects;


/**
 * t[[Nθ`DTA
 * @author nori
 *
 */
public class GaConfigValues {
	
	private static GaConfigValues instance = null;
	//IπiΏj­Ά¦
	private Double incidenceSelection = null;
	//π³­Ά¦
	private Double incidenceCrossOver = null;
	//ΛRΟΩ­Ά¦
	private Double incidenceMutation = null;
	//IπiΏjNX
	private String classPathSelection = null;
	//π³NX
	private String classPathCrossOver = null;
	public String getClassPathInit() {
		return classPathInit;
	}

	public void setClassPathInit(String classPathInit) {
		this.classPathInit = classPathInit;
	}

	//ΛRΟΩNX
	private String classPathMutation = null;
	//ϊNX
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

	//ΒΜ
	private Integer num = 0;
	
	private GaConfigValues() {}
	
	/**
	 * GaConfigValues Factory@Method
	 * @return
	 */
	public static GaConfigValues getInstance() {
		if(Objects.isNull(instance)) instance = new GaConfigValues();
		return instance;
	}
	
	/**
	 * π³­Ά¦Getter
	 * @return π³­Ά¦
	 */
	public Double getIncidenceCrossOver() {
		return incidenceCrossOver;
	}
	
	/**
	 * π³­Ά¦Setter
	 * @param incidenceCrossOver π³­Ά¦
	 */
	public void setIncidenceCrossOver(Double incidenceCrossOver) {
		this.incidenceCrossOver = incidenceCrossOver;
	}
	
	/**
	 * ΛRΟΩ­Ά¦Getter
	 * @return ΛRΟΩ­Ά¦
	 */
	public Double getIncidenceMutation() {
		return incidenceMutation;
	}
	
	/**
	 * ΛRΟΩ­Ά¦Setter
	 * @param incidenceMutation ΛRΟΩ­Ά¦
	 */
	public void setIncidenceMutation(Double incidenceMutation) {
		this.incidenceMutation = incidenceMutation;
	}
	
	/**
	 * ΒΜGetter
	 * @return@ΒΜ
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * ΒΜSetter
	 * @param num@ΒΜ
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

package jp.ga.fw.dta;

import java.util.Objects;


/**
 * フレームワーク定義DTA
 * @author nori
 *
 */
public class GaConfigValues {
	
	private static GaConfigValues instance = null;
	//選択（淘汰）発生率
	private Double incidenceSelection = null;
	//交叉発生率
	private Double incidenceCrossOver = null;
	//突然変異発生率
	private Double incidenceMutation = null;
	//選択（淘汰）クラス
	private String classPathSelection = null;
	//交叉クラス
	private String classPathCrossOver = null;
	public String getClassPathInit() {
		return classPathInit;
	}

	public void setClassPathInit(String classPathInit) {
		this.classPathInit = classPathInit;
	}

	//突然変異クラス
	private String classPathMutation = null;
	//初期処理クラス
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

	//個体数
	private Integer num = 0;
	
	private GaConfigValues() {}
	
	/**
	 * GaConfigValues Factory　Method
	 * @return
	 */
	public static GaConfigValues getInstance() {
		if(Objects.isNull(instance)) instance = new GaConfigValues();
		return instance;
	}
	
	/**
	 * 交叉発生率Getter
	 * @return 交叉発生率
	 */
	public Double getIncidenceCrossOver() {
		return incidenceCrossOver;
	}
	
	/**
	 * 交叉発生率Setter
	 * @param incidenceCrossOver 交叉発生率
	 */
	public void setIncidenceCrossOver(Double incidenceCrossOver) {
		this.incidenceCrossOver = incidenceCrossOver;
	}
	
	/**
	 * 突然変異発生率Getter
	 * @return 突然変異発生率
	 */
	public Double getIncidenceMutation() {
		return incidenceMutation;
	}
	
	/**
	 * 突然変異発生率Setter
	 * @param incidenceMutation 突然変異発生率
	 */
	public void setIncidenceMutation(Double incidenceMutation) {
		this.incidenceMutation = incidenceMutation;
	}
	
	/**
	 * 個体数Getter
	 * @return　個体数
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 個体数Setter
	 * @param num　個体数
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

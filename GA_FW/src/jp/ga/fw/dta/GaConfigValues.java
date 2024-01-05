package jp.ga.fw.dta;

import java.util.Objects;


/**
 * t[[Nθ`DTA
 * @author nori
 *
 */
public class GaConfigValues {
	
	private static GaConfigValues instance = null;
	
	//π³­Ά¦
	private Double incidenceCrossOver = null;
	//ΛRΟΩ­Ά¦
	private Double incidenceMutation = null;
	
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
	
	
	
}

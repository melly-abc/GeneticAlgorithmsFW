package jp.ga.fw.dta;

import java.util.Objects;

public class GaConfigValues {
	
	private static GaConfigValues instance = null;
	
	//ð³­¶¦
	private Double incidenceCrossOver = null;
	//ËRÏÙ­¶¦
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
	 * ð³­¶¦Getter
	 * @return ð³­¶¦
	 */
	public Double getIncidenceCrossOver() {
		return incidenceCrossOver;
	}
	
	/**
	 * ð³­¶¦Setter
	 * @param incidenceCrossOver ð³­¶¦
	 */
	public void setIncidenceCrossOver(Double incidenceCrossOver) {
		this.incidenceCrossOver = incidenceCrossOver;
	}
	
	/**
	 * ËRÏÙ­¶¦Getter
	 * @return ËRÏÙ­¶¦
	 */
	public Double getIncidenceMutation() {
		return incidenceMutation;
	}
	
	/**
	 * ËRÏÙ­¶¦Setter
	 * @param incidenceMutation ËRÏÙ­¶¦
	 */
	public void setIncidenceMutation(Double incidenceMutation) {
		this.incidenceMutation = incidenceMutation;
	}
	
	
	
}

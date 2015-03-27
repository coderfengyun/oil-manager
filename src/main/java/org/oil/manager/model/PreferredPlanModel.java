package org.oil.manager.model;

public class PreferredPlanModel {
	private int id;
	private double pumpEffeciency;
	private double systemEffeciency;
	private double production;
	private double econemicBenifits;
	private double utilization;
	private int wellId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPumpEffeciency() {
		return pumpEffeciency;
	}

	public void setPumpEffeciency(double pumpEffeciency) {
		this.pumpEffeciency = pumpEffeciency;
	}

	public double getSystemEffeciency() {
		return systemEffeciency;
	}

	public void setSystemEffeciency(double systemEffeciency) {
		this.systemEffeciency = systemEffeciency;
	}

	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	public double getEconemicBenifits() {
		return econemicBenifits;
	}

	public void setEconemicBenifits(double econemicBenifits) {
		this.econemicBenifits = econemicBenifits;
	}

	public double getUtilization() {
		return utilization;
	}

	public void setUtilization(double utilization) {
		this.utilization = utilization;
	}

	public int getWellId() {
		return wellId;
	}

	public void setWellId(int wellId) {
		this.wellId = wellId;
	}

	public static PreferredPlanModel build(int id, double econemicBenifits,
			double production, double pumpEffeciency, double systemEffeciency,
			double utilization, int wellId) {
		PreferredPlanModel result = new PreferredPlanModel();
		result.setId(id);
		result.setEconemicBenifits(econemicBenifits);
		result.setProduction(production);
		result.setPumpEffeciency(pumpEffeciency);
		result.setSystemEffeciency(systemEffeciency);
		result.setUtilization(utilization);
		result.setWellId(wellId);
		return result;
	}

}

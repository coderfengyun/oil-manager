package org.oil.manager.model;

public class WellInflowTrendModel {
	private int id;
	private double producedFluidVolume;
	private double wellBotomFlowPressure;
	private int wellId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getProducedFluidVolume() {
		return producedFluidVolume;
	}

	public void setProducedFluidVolume(double producedFluidVolume) {
		this.producedFluidVolume = producedFluidVolume;
	}

	public double getWellBotomFlowPressure() {
		return wellBotomFlowPressure;
	}

	public void setWellBotomFlowPressure(double wellBotomFlowPressure) {
		this.wellBotomFlowPressure = wellBotomFlowPressure;
	}

	public int getWellId() {
		return wellId;
	}

	public void setWellId(int wellId) {
		this.wellId = wellId;
	}

	public static WellInflowTrendModel build(int id,
			double producedFluidVolume, double wellBotomFlowPressure, int wellId) {
		WellInflowTrendModel result = new WellInflowTrendModel();
		result.setId(wellId);
		result.setProducedFluidVolume(producedFluidVolume);
		result.setWellBotomFlowPressure(wellBotomFlowPressure);
		result.setWellId(wellId);
		return result;
	}
}

package org.oil.manager.model;

public class WellPressureDistributionModel {
	private int id;
	private double pumpDepth;
	private double sinkingPressure;
	private double fulfillCoefficient;
	private int wellId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPumpDepth() {
		return pumpDepth;
	}

	public void setPumpDepth(double pumpDepth) {
		this.pumpDepth = pumpDepth;
	}

	public double getSinkingPressure() {
		return sinkingPressure;
	}

	public void setSinkingPressure(double sinkingPressure) {
		this.sinkingPressure = sinkingPressure;
	}

	public double getFulfillCoefficient() {
		return fulfillCoefficient;
	}

	public void setFulfillCoefficient(double fulfillCoefficient) {
		this.fulfillCoefficient = fulfillCoefficient;
	}

	public int getWellId() {
		return wellId;
	}

	public void setWellId(int wellId) {
		this.wellId = wellId;
	}

	public static WellPressureDistributionModel build(double pumpDepth,
			double sinkingPressure, double fulfillCoefficient, int wellId) {
		WellPressureDistributionModel result = new WellPressureDistributionModel();
		result.setFulfillCoefficient(fulfillCoefficient);
		result.setPumpDepth(pumpDepth);
		result.setSinkingPressure(sinkingPressure);
		result.setWellId(wellId);
		return result;
	}
}

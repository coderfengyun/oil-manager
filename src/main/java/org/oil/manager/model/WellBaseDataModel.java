package org.oil.manager.model;

public class WellBaseDataModel {
	private int id;
	private double wellDepth;
	private double casingOutterDiameter;
	private double casingInnerDiameter;
	private double reservoirTemperature;
	private double tubingOutterDiameter;
	private double tubingInnerDiameter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWellDepth() {
		return wellDepth;
	}

	public void setWellDepth(double wellDepth) {
		this.wellDepth = wellDepth;
	}

	public double getCasingOutterDiameter() {
		return casingOutterDiameter;
	}

	public void setCasingOutterDiameter(double casingOutterDiameter) {
		this.casingOutterDiameter = casingOutterDiameter;
	}

	public double getCasingInnerDiameter() {
		return casingInnerDiameter;
	}

	public void setCasingInnerDiameter(double casingInnerDiameter) {
		this.casingInnerDiameter = casingInnerDiameter;
	}

	public double getReservoirTemperature() {
		return reservoirTemperature;
	}

	public void setReservoirTemperature(double reservoirTemperature) {
		this.reservoirTemperature = reservoirTemperature;
	}

	public double getTubingOutterDiameter() {
		return tubingOutterDiameter;
	}

	public void setTubingOutterDiameter(double tubingOutterDiameter) {
		this.tubingOutterDiameter = tubingOutterDiameter;
	}

	public double getTubingInnerDiameter() {
		return tubingInnerDiameter;
	}

	public void setTubingInnerDiameter(double tubingInnerDiameter) {
		this.tubingInnerDiameter = tubingInnerDiameter;
	}

	public static WellBaseDataModel build(int id, double wellDepth,
			double casingOutterDiameter, double casingInnerDiameter,
			double reservoirTemperature, double tubingOutterDiameter,
			double tubingInnerDiameter) {
		WellBaseDataModel result = new WellBaseDataModel();
		result.setId(id);
		result.setWellDepth(wellDepth);
		result.setCasingOutterDiameter(casingOutterDiameter);
		result.setCasingInnerDiameter(casingInnerDiameter);
		result.setReservoirTemperature(reservoirTemperature);
		result.setTubingOutterDiameter(tubingOutterDiameter);
		result.setTubingInnerDiameter(tubingInnerDiameter);
		return result;
	}
}

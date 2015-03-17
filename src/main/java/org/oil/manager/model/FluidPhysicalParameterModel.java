package org.oil.manager.model;

public class FluidPhysicalParameterModel {
	private int id;
	private double saturationPressure;
	private double reservoirPressure;
	private double crudeOilDensity;
	private double crudeOilViscosity;
	private double formationWaterDensity;
	private double gasPhaseRelativeDensity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaturationPressure() {
		return saturationPressure;
	}

	public void setSaturationPressure(double saturationPressure) {
		this.saturationPressure = saturationPressure;
	}

	public double getReservoirPressure() {
		return reservoirPressure;
	}

	public void setReservoirPressure(double reservoirPressure) {
		this.reservoirPressure = reservoirPressure;
	}

	public double getCrudeOilDensity() {
		return crudeOilDensity;
	}

	public void setCrudeOilDensity(double crudeOilDensity) {
		this.crudeOilDensity = crudeOilDensity;
	}

	public double getCrudeOilViscosity() {
		return crudeOilViscosity;
	}

	public void setCrudeOilViscosity(double crudeOilViscosity) {
		this.crudeOilViscosity = crudeOilViscosity;
	}

	public double getFormationWaterDensity() {
		return formationWaterDensity;
	}

	public void setFormationWaterDensity(double formationWaterDensity) {
		this.formationWaterDensity = formationWaterDensity;
	}

	public double getGasPhaseRelativeDensity() {
		return gasPhaseRelativeDensity;
	}

	public void setGasPhaseRelativeDensity(double gasPhaseRelativeDensity) {
		this.gasPhaseRelativeDensity = gasPhaseRelativeDensity;
	}

	public static FluidPhysicalParameterModel build(int id,
			double saturationPressure, double reservoirPressure,
			double crudeOilDensity, double crudeOilViscosity,
			double formationWaterDensity, double gasPhaseRelativeDensity) {
		FluidPhysicalParameterModel result = new FluidPhysicalParameterModel();
		result.setCrudeOilDensity(crudeOilDensity);
		result.setCrudeOilViscosity(crudeOilViscosity);
		result.setFormationWaterDensity(formationWaterDensity);
		result.setGasPhaseRelativeDensity(gasPhaseRelativeDensity);
		result.setId(id);
		result.setReservoirPressure(reservoirPressure);
		result.setSaturationPressure(saturationPressure);
		return result;
	}
}

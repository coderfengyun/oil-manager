package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fluidPhysicalParameter")
public class FluidPhysicalParameter implements Aggregate {
	private int id;
	private double saturationPressure;
	private double reservoirPressure;
	private double crudeOilDensity;
	private double crudeOilViscosity;
	private double formationWaterDensity;
	private double gasPhaseRelativeDensity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "saturationPressure", nullable = false)
	public double getSaturationPressure() {
		return saturationPressure;
	}

	public void setSaturationPressure(double saturationPressure) {
		this.saturationPressure = saturationPressure;
	}

	@Column(name = "reservoirPressure", nullable = false)
	public double getReservoirPressure() {
		return reservoirPressure;
	}

	public void setReservoirPressure(double reservoirPressure) {
		this.reservoirPressure = reservoirPressure;
	}

	@Column(name = "crudeOilDensity", nullable = false)
	public double getCrudeOilDensity() {
		return crudeOilDensity;
	}

	public void setCrudeOilDensity(double crudeOilDensity) {
		this.crudeOilDensity = crudeOilDensity;
	}

	@Column(name = "crudeOilViscosity", nullable = false)
	public double getCrudeOilViscosity() {
		return crudeOilViscosity;
	}

	public void setCrudeOilViscosity(double crudeOilViscosity) {
		this.crudeOilViscosity = crudeOilViscosity;
	}

	@Column(name = "formationWaterDensity", nullable = false)
	public double getFormationWaterDensity() {
		return formationWaterDensity;
	}

	public void setFormationWaterDensity(double formationWaterDensity) {
		this.formationWaterDensity = formationWaterDensity;
	}

	@Column(name = "gasPhaseRelativeDensity", nullable = false)
	public double getGasPhaseRelativeDensity() {
		return gasPhaseRelativeDensity;
	}

	public void setGasPhaseRelativeDensity(double gasPhaseRelativeDensity) {
		this.gasPhaseRelativeDensity = gasPhaseRelativeDensity;
	}

	public static FluidPhysicalParameter buildWithoutId(
			double saturationPressure, double reservoirPressure,
			double crudeOilDensity, double crudeOilViscosity,
			double formationWaterDensity, double gasPhaseRelativeDensity) {
		FluidPhysicalParameter result = new FluidPhysicalParameter();
		result.setCrudeOilDensity(crudeOilDensity);
		result.setCrudeOilViscosity(crudeOilViscosity);
		result.setFormationWaterDensity(formationWaterDensity);
		result.setGasPhaseRelativeDensity(gasPhaseRelativeDensity);
		result.setReservoirPressure(reservoirPressure);
		result.setSaturationPressure(saturationPressure);
		return result;
	}
}

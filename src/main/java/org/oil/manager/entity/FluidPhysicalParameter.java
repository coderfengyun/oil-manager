package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	private WellBaseData wellBaseData;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "saturationPressure")
	public double getSaturationPressure() {
		return saturationPressure;
	}

	public void setSaturationPressure(double saturationPressure) {
		this.saturationPressure = saturationPressure;
	}

	@Column(name = "reservoirPressure")
	public double getReservoirPressure() {
		return reservoirPressure;
	}

	public void setReservoirPressure(double reservoirPressure) {
		this.reservoirPressure = reservoirPressure;
	}

	@Column(name = "crudeOilDensity")
	public double getCrudeOilDensity() {
		return crudeOilDensity;
	}

	public void setCrudeOilDensity(double crudeOilDensity) {
		this.crudeOilDensity = crudeOilDensity;
	}

	@Column(name = "crudeOilViscosity")
	public double getCrudeOilViscosity() {
		return crudeOilViscosity;
	}

	public void setCrudeOilViscosity(double crudeOilViscosity) {
		this.crudeOilViscosity = crudeOilViscosity;
	}

	@Column(name = "formationWaterDensity")
	public double getFormationWaterDensity() {
		return formationWaterDensity;
	}

	public void setFormationWaterDensity(double formationWaterDensity) {
		this.formationWaterDensity = formationWaterDensity;
	}

	@Column(name = "gasPhaseRelativeDensity")
	public double getGasPhaseRelativeDensity() {
		return gasPhaseRelativeDensity;
	}

	public void setGasPhaseRelativeDensity(double gasPhaseRelativeDensity) {
		this.gasPhaseRelativeDensity = gasPhaseRelativeDensity;
	}

	@OneToOne(mappedBy = "fluidPhysicalParameter")
	public WellBaseData getWellBaseData() {
		return wellBaseData;
	}

	public void setWellBaseData(WellBaseData wellBaseData) {
		this.wellBaseData = wellBaseData;
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

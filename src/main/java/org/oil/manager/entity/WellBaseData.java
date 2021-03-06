package org.oil.manager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wellBaseData")
public class WellBaseData implements Aggregate {
	private int id;
	private double wellDepth;
	private double casingOutterDiameter;
	private double casingInnerDiameter;
	private double reservoirTemperature;
	private double tubingOutterDiameter;
	private double tubingInnerDiameter;
	private FluidPhysicalParameter fluidPhysicalParameter;
	private IndicatorWeightDistribution indicatorWeightDistribution;
	private RodStringDesignParameter rodStringDesignParameter;
	private RodStructureParameter rodStructureParameter;
	private WellDesignParameter wellDesignParameter;
	private WellProductData wellProductData;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "wellDepth", nullable = false)
	public double getWellDepth() {
		return wellDepth;
	}

	public void setWellDepth(double wellDepth) {
		this.wellDepth = wellDepth;
	}

	@Column(name = "casingOutterDiameter", nullable = false)
	public double getCasingOutterDiameter() {
		return casingOutterDiameter;
	}

	public void setCasingOutterDiameter(double casingOutterDiameter) {
		this.casingOutterDiameter = casingOutterDiameter;
	}

	@Column(name = "casingInnerDiameter", nullable = false)
	public double getCasingInnerDiameter() {
		return casingInnerDiameter;
	}

	public void setCasingInnerDiameter(double casingInnerDiameter) {
		this.casingInnerDiameter = casingInnerDiameter;
	}

	@Column(name = "reservoirTemperature", nullable = false)
	public double getReservoirTemperature() {
		return reservoirTemperature;
	}

	public void setReservoirTemperature(double reservoirTemperature) {
		this.reservoirTemperature = reservoirTemperature;
	}

	@Column(name = "tubingOutterDiameter", nullable = false)
	public double getTubingOutterDiameter() {
		return tubingOutterDiameter;
	}

	public void setTubingOutterDiameter(double tubingOutterDiameter) {
		this.tubingOutterDiameter = tubingOutterDiameter;
	}

	@Column(name = "tubingInnerDiameter", nullable = false)
	public double getTubingInnerDiameter() {
		return tubingInnerDiameter;
	}

	public void setTubingInnerDiameter(double tubingInnerDiameter) {
		this.tubingInnerDiameter = tubingInnerDiameter;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fluidPhysicalParameterId")
	public FluidPhysicalParameter getFluidPhysicalParameter() {
		return fluidPhysicalParameter;
	}

	public void setFluidPhysicalParameter(
			FluidPhysicalParameter fluidPhysicalParameter) {
		this.fluidPhysicalParameter = fluidPhysicalParameter;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "indicatorWeightDistributionId")
	public IndicatorWeightDistribution getIndicatorWeightDistribution() {
		return indicatorWeightDistribution;
	}

	public void setIndicatorWeightDistribution(
			IndicatorWeightDistribution indicatorWeightDistribution) {
		this.indicatorWeightDistribution = indicatorWeightDistribution;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rodStringDesignParameterId")
	public RodStringDesignParameter getRodStringDesignParameter() {
		return rodStringDesignParameter;
	}

	public void setRodStringDesignParameter(
			RodStringDesignParameter rodStringDesignParameter) {
		this.rodStringDesignParameter = rodStringDesignParameter;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rodStructureParameterId")
	public RodStructureParameter getRodStructureParameter() {
		return rodStructureParameter;
	}

	public void setRodStructureParameter(
			RodStructureParameter rodStructureParameter) {
		this.rodStructureParameter = rodStructureParameter;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wellDesignParameterId")
	public WellDesignParameter getWellDesignParameter() {
		return wellDesignParameter;
	}

	public void setWellDesignParameter(WellDesignParameter wellDesignParameter) {
		this.wellDesignParameter = wellDesignParameter;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "wellProductDataId")
	public WellProductData getWellProductData() {
		return wellProductData;
	}

	public void setWellProductData(WellProductData wellProductData) {
		this.wellProductData = wellProductData;
	}

	public static WellBaseData buildWithoutId(double wellDepth,
			double casingOutterDiameter, double casingInnerDiameter,
			double reservoirTemperature, double tubingOutterDiameter,
			double tubingInnerDiameter) {
		WellBaseData result = new WellBaseData();
		result.setWellDepth(wellDepth);
		result.setCasingInnerDiameter(casingInnerDiameter);
		result.setCasingOutterDiameter(casingOutterDiameter);
		result.setReservoirTemperature(reservoirTemperature);
		result.setTubingInnerDiameter(tubingInnerDiameter);
		result.setTubingOutterDiameter(tubingOutterDiameter);
		return result;
	}
}

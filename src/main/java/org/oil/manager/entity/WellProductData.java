package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wellProductData")
public class WellProductData implements Aggregate {
	private int id;
	private String pumpingMachineType;
	private double producingOilRate;
	private double production;
	private double pumpDiameter;
	private double stroke;
	private int bluntTimes;
	private double wellHeadCasingPressure;
	private double pumpDepth;
	private double volumetricMoistureContent;
	private double workingFluidLevel;
	private double sternTubeLength;
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

	@Column(name = "pumpingMachineType")
	public String getPumpingMachineType() {
		return pumpingMachineType;
	}

	public void setPumpingMachineType(String pumpingMachineType) {
		this.pumpingMachineType = pumpingMachineType;
	}

	@Column(name = "producingOilRate")
	public double getProducingOilRate() {
		return producingOilRate;
	}

	public void setProducingOilRate(double producingOilRate) {
		this.producingOilRate = producingOilRate;
	}

	@Column(name = "production")
	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	@Column(name = "pumpDiameter")
	public double getPumpDiameter() {
		return pumpDiameter;
	}

	public void setPumpDiameter(double pumpDiameter) {
		this.pumpDiameter = pumpDiameter;
	}

	@Column(name = "stroke")
	public double getStroke() {
		return stroke;
	}

	public void setStroke(double stroke) {
		this.stroke = stroke;
	}

	@Column(name = "bluntTimes")
	public int getBluntTimes() {
		return bluntTimes;
	}

	public void setBluntTimes(int bluntTimes) {
		this.bluntTimes = bluntTimes;
	}

	@Column(name = "wellHeadCasingPressure")
	public double getWellHeadCasingPressure() {
		return wellHeadCasingPressure;
	}

	public void setWellHeadCasingPressure(double wellHeadCasingPressure) {
		this.wellHeadCasingPressure = wellHeadCasingPressure;
	}

	@Column(name = "pumpDepth")
	public double getPumpDepth() {
		return pumpDepth;
	}

	public void setPumpDepth(double pumpDepth) {
		this.pumpDepth = pumpDepth;
	}

	@Column(name = "volumetricMoistureContent")
	public double getVolumetricMoistureContent() {
		return volumetricMoistureContent;
	}

	public void setVolumetricMoistureContent(double volumetricMoistureContent) {
		this.volumetricMoistureContent = volumetricMoistureContent;
	}

	@Column(name = "workingFluidLevel")
	public double getWorkingFluidLevel() {
		return workingFluidLevel;
	}

	public void setWorkingFluidLevel(double workingFluidLevel) {
		this.workingFluidLevel = workingFluidLevel;
	}

	@Column(name = "sternTubeLength")
	public double getSternTubeLength() {
		return sternTubeLength;
	}

	public void setSternTubeLength(double sternTubeLength) {
		this.sternTubeLength = sternTubeLength;
	}

	@OneToOne(mappedBy = "wellDesignParameter")
	public WellBaseData getWellBaseData() {
		return wellBaseData;
	}

	public void setWellBaseData(WellBaseData wellBaseData) {
		this.wellBaseData = wellBaseData;
	}

	public static WellProductData buildWithoutId(String pumpingMachineType,
			double producingOilRate, double production, double pumpDiameter,
			double stroke, int bluntTimes, double wellHeadCasingPressure,
			double pumpDepth, double volumetricMoistureContent,
			double workingFluidLevel, double sternTubeLength) {
		WellProductData result = new WellProductData();
		result.setBluntTimes(bluntTimes);
		result.setProducingOilRate(producingOilRate);
		result.setProduction(production);
		result.setPumpDepth(pumpDepth);
		result.setPumpDiameter(pumpDiameter);
		result.setPumpingMachineType(pumpingMachineType);
		result.setSternTubeLength(sternTubeLength);
		result.setStroke(stroke);
		result.setVolumetricMoistureContent(volumetricMoistureContent);
		result.setWellHeadCasingPressure(wellHeadCasingPressure);
		result.setWorkingFluidLevel(workingFluidLevel);
		return result;
	}
}

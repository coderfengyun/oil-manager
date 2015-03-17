package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wellBaseData")
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "pumpingMachineType", nullable = false)
	public String getPumpingMachineType() {
		return pumpingMachineType;
	}

	public void setPumpingMachineType(String pumpingMachineType) {
		this.pumpingMachineType = pumpingMachineType;
	}

	@Column(name = "producingOilRate", nullable = false)
	public double getProducingOilRate() {
		return producingOilRate;
	}

	public void setProducingOilRate(double producingOilRate) {
		this.producingOilRate = producingOilRate;
	}

	@Column(name = "production", nullable = false)
	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	@Column(name = "pumpDiameter", nullable = false)
	public double getPumpDiameter() {
		return pumpDiameter;
	}

	public void setPumpDiameter(double pumpDiameter) {
		this.pumpDiameter = pumpDiameter;
	}

	@Column(name = "stroke", nullable = false)
	public double getStroke() {
		return stroke;
	}

	public void setStroke(double stroke) {
		this.stroke = stroke;
	}

	@Column(name = "bluntTimes", nullable = false)
	public int getBluntTimes() {
		return bluntTimes;
	}

	public void setBluntTimes(int bluntTimes) {
		this.bluntTimes = bluntTimes;
	}

	@Column(name = "wellHeadCasingPressure", nullable = false)
	public double getWellHeadCasingPressure() {
		return wellHeadCasingPressure;
	}

	public void setWellHeadCasingPressure(double wellHeadCasingPressure) {
		this.wellHeadCasingPressure = wellHeadCasingPressure;
	}

	@Column(name = "pumpDepth", nullable = false)
	public double getPumpDepth() {
		return pumpDepth;
	}

	public void setPumpDepth(double pumpDepth) {
		this.pumpDepth = pumpDepth;
	}

	@Column(name = "volumetricMoistureContent", nullable = false)
	public double getVolumetricMoistureContent() {
		return volumetricMoistureContent;
	}

	public void setVolumetricMoistureContent(double volumetricMoistureContent) {
		this.volumetricMoistureContent = volumetricMoistureContent;
	}

	@Column(name = "workingFluidLevel", nullable = false)
	public double getWorkingFluidLevel() {
		return workingFluidLevel;
	}

	public void setWorkingFluidLevel(double workingFluidLevel) {
		this.workingFluidLevel = workingFluidLevel;
	}

	@Column(name = "sternTubeLength", nullable = false)
	public double getSternTubeLength() {
		return sternTubeLength;
	}

	public void setSternTubeLength(double sternTubeLength) {
		this.sternTubeLength = sternTubeLength;
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

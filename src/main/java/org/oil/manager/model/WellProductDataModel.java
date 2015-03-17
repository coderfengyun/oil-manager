package org.oil.manager.model;

public class WellProductDataModel {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPumpingMachineType() {
		return pumpingMachineType;
	}

	public void setPumpingMachineType(String pumpingMachineType) {
		this.pumpingMachineType = pumpingMachineType;
	}

	public double getProducingOilRate() {
		return producingOilRate;
	}

	public void setProducingOilRate(double producingOilRate) {
		this.producingOilRate = producingOilRate;
	}

	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	public double getPumpDiameter() {
		return pumpDiameter;
	}

	public void setPumpDiameter(double pumpDiameter) {
		this.pumpDiameter = pumpDiameter;
	}

	public double getStroke() {
		return stroke;
	}

	public void setStroke(double stroke) {
		this.stroke = stroke;
	}

	public int getBluntTimes() {
		return bluntTimes;
	}

	public void setBluntTimes(int bluntTimes) {
		this.bluntTimes = bluntTimes;
	}

	public double getWellHeadCasingPressure() {
		return wellHeadCasingPressure;
	}

	public void setWellHeadCasingPressure(double wellHeadCasingPressure) {
		this.wellHeadCasingPressure = wellHeadCasingPressure;
	}

	public double getPumpDepth() {
		return pumpDepth;
	}

	public void setPumpDepth(double pumpDepth) {
		this.pumpDepth = pumpDepth;
	}

	public double getVolumetricMoistureContent() {
		return volumetricMoistureContent;
	}

	public void setVolumetricMoistureContent(double volumetricMoistureContent) {
		this.volumetricMoistureContent = volumetricMoistureContent;
	}

	public double getWorkingFluidLevel() {
		return workingFluidLevel;
	}

	public void setWorkingFluidLevel(double workingFluidLevel) {
		this.workingFluidLevel = workingFluidLevel;
	}

	public double getSternTubeLength() {
		return sternTubeLength;
	}

	public void setSternTubeLength(double sternTubeLength) {
		this.sternTubeLength = sternTubeLength;
	}

	public static WellProductDataModel build(int id, int bluntTimes,
			double production, double producingOilRate, double pumpDepth,
			double pumpDiameter, String pumpingMachineType,
			double sternTubeLength, double stroke,
			double volumetricMoistureContent, double wellHeadCasingPressure,
			double workingFluidLevel) {
		WellProductDataModel result = new WellProductDataModel();
		result.setId(id);
		result.setBluntTimes(bluntTimes);
		result.setProduction(production);
		result.setProducingOilRate(producingOilRate);
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

package org.oil.manager.api;

import java.util.LinkedList;
import java.util.List;

import org.oil.manager.entity.FluidPhysicalParameter;
import org.oil.manager.entity.IndicatorWeightDistribution;
import org.oil.manager.entity.RodStringDesignParameter;
import org.oil.manager.entity.RodStructureParameter;
import org.oil.manager.entity.WellDesignParameter;
import org.oil.manager.entity.WellProductData;
import org.oil.manager.model.FluidPhysicalParameterModel;
import org.oil.manager.model.WellBaseDataModel;
import org.oil.manager.model.WellProductDataModel;
import org.oil.manager.service.FluidPhysicalParameterService;
import org.oil.manager.service.IndicatorWeightDistributionService;
import org.oil.manager.service.RodStringDesignParameterService;
import org.oil.manager.service.RodStructureParameterService;
import org.oil.manager.service.WellBaseDataService;
import org.oil.manager.service.WellDesignParameterService;
import org.oil.manager.service.WellProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/well")
public class BaseDataController {
	@Autowired
	private WellBaseDataService wellBaseDataService;
	@Autowired
	private WellProductDataService wellProductDataService;
	@Autowired
	private FluidPhysicalParameterService fluidPhysicalParameterService;
	@Autowired
	private RodStringDesignParameterService rodStringDesignParameterService;
	@Autowired
	private WellDesignParameterService wellDesignParameterService;
	@Autowired
	private RodStructureParameterService rodStructureParameterSerice;
	@Autowired
	private IndicatorWeightDistributionService indicatorWeightDistributionService;

	@RequestMapping(value = "/insertWellBaseData", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertWellBaseData(@RequestParam double wellDepth,
			@RequestParam double casingOutterDiameter,
			@RequestParam double casingInnerDiameter,
			@RequestParam double reservoirTemperature,
			@RequestParam double tubingOutterDiameter,
			@RequestParam double tubingInnerDiameter) {
		System.out.println("enter insertWellBaseData Controller!");
		return this.wellBaseDataService
				.addAWellBaseData(wellDepth, casingOutterDiameter,
						casingInnerDiameter, reservoirTemperature,
						tubingOutterDiameter, tubingInnerDiameter);
	}

	@RequestMapping(value = "/baseData", method = RequestMethod.GET)
	@ResponseBody
	public List<WellBaseDataModel> queryAllWellBaseData() {
		System.out.println("enter queryAllWellBaseData");
		return this.wellBaseDataService.queryAllWellBaseData();
	}

	@RequestMapping(value = "/insertWellProductData", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertWellProductData(
			@RequestParam String pumpingMachineType,
			@RequestParam double producingOilRate,
			@RequestParam double production, @RequestParam double pumpDiameter,
			@RequestParam double stroke, @RequestParam int bluntTimes,
			@RequestParam double wellHeadCasingPressure,
			@RequestParam double pumpDepth,
			@RequestParam double volumetricMoistureContent,
			@RequestParam double workingFluidLevel,
			@RequestParam double sternTubeLength) {
		return this.wellProductDataService.addAWellProductData(
				pumpingMachineType, producingOilRate, production, pumpDiameter,
				stroke, bluntTimes, wellHeadCasingPressure, pumpDepth,
				volumetricMoistureContent, workingFluidLevel, sternTubeLength);
	}

	@RequestMapping(value = "/productData", method = RequestMethod.GET)
	@ResponseBody
	public List<WellProductDataModel> queryAllWellProductData() {
		return convert2(this.wellProductDataService.findAll());
	}

	private List<WellProductDataModel> convert2(List<WellProductData> findAll) {
		List<WellProductDataModel> result = new LinkedList<WellProductDataModel>();
		for (WellProductData item : findAll) {
			result.add(WellProductDataModel.build(item.getId(),
					item.getBluntTimes(), item.getProduction(),
					item.getProducingOilRate(), item.getPumpDepth(),
					item.getPumpDiameter(), item.getPumpingMachineType(),
					item.getSternTubeLength(), item.getStroke(),
					item.getVolumetricMoistureContent(),
					item.getWellHeadCasingPressure(),
					item.getWorkingFluidLevel()));
		}
		return result;
	}

	@RequestMapping(value = "/insertFluidPhysicalParameters", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertFluidPhysicalParameters(
			@RequestParam double saturationPressure,
			@RequestParam double reservoirPressure,
			@RequestParam double crudeOilDensity,
			@RequestParam double crudeOilViscosity,
			@RequestParam double formationWaterDensity,
			@RequestParam double gasPhaseRelativeDensity) {
		return this.fluidPhysicalParameterService.addAFluidPhysicalParameter(
				saturationPressure, reservoirPressure, crudeOilDensity,
				crudeOilViscosity, formationWaterDensity,
				gasPhaseRelativeDensity);
	}

	@RequestMapping(value = "/fluidPhysicalParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<FluidPhysicalParameterModel> queryAllFluidPhysicalParameter() {
		return convert2FluidPhysicalParameterMode(this.fluidPhysicalParameterService
				.findAll());
	}

	private List<FluidPhysicalParameterModel> convert2FluidPhysicalParameterMode(
			List<FluidPhysicalParameter> findAll) {
		List<FluidPhysicalParameterModel> result = new LinkedList<FluidPhysicalParameterModel>();
		for (FluidPhysicalParameter item : findAll) {
			result.add(FluidPhysicalParameterModel.build(item.getId(),
					item.getSaturationPressure(), item.getSaturationPressure(),
					item.getCrudeOilDensity(), item.getCrudeOilViscosity(),
					item.getFormationWaterDensity(),
					item.getGasPhaseRelativeDensity()));
		}
		return result;
	}

	@RequestMapping(value = "/insertWellDesignParameters", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertWellDesignParameters(
			@RequestParam double producedFluidVolume,
			@RequestParam double moistureRatio,
			@RequestParam double minProducedFluidVolume,
			@RequestParam double minPumpEfficiency) {
		return this.wellDesignParameterService.addAWellDesignParameter(
				producedFluidVolume, moistureRatio, minProducedFluidVolume,
				minPumpEfficiency);
	}

	@RequestMapping(value = "/wellDesignParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<WellDesignParameter> queryAllWellDesignParameter() {
		return this.wellDesignParameterService.findAll();
	}

	@RequestMapping(value = "/insertRodStringDesignParameters", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertRodStringDesignParameters(
			@RequestParam double safetyFactor, @RequestParam byte poleLevel,
			@RequestParam double minRodDiameter) {
		this.rodStringDesignParameterService.addARodStringDesignParameter(
				safetyFactor, poleLevel, minRodDiameter);
		return true;
	}

	@RequestMapping(value = "/rodStringDesignParameter", method = RequestMethod.GET)
	public List<RodStringDesignParameter> queryAllRodStringDesignParameter() {
		return this.rodStringDesignParameterService.findAll();
	}

	@RequestMapping(value = "/insertRodStructureParameters", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertRodStructureParameters(@RequestParam byte poleLevel,
			@RequestParam double rodDiameter, @RequestParam double rodLength) {
		return this.rodStructureParameterSerice.addARodStructureParameter(
				poleLevel, rodDiameter, rodLength);
	}

	@RequestMapping(value = "/rodStructureParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<RodStructureParameter> queryAllRodStructureParameter() {
		return this.rodStructureParameterSerice.findAll();
	}

	@RequestMapping(value = "/insertIndicatorWeightDistribution", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean insertIndicatorWeightDistribution(
			@RequestParam String productionCoordination,
			@RequestParam double pumpEffeciency,
			@RequestParam double systemEffeciency,
			@RequestParam double production,
			@RequestParam double econemicBenifits,
			@RequestParam double utilization) {
		return this.indicatorWeightDistributionService
				.addAIndicatorWeightDistribution(productionCoordination,
						pumpEffeciency, systemEffeciency, production,
						econemicBenifits, utilization);
	}

	@RequestMapping(value = "/indicatorWeightDistribution", method = RequestMethod.GET)
	public List<IndicatorWeightDistribution> queryAllIndicatorWeightDistribution() {
		return this.indicatorWeightDistributionService.findAll();
	}
}

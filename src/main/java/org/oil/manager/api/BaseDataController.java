package org.oil.manager.api;

import java.util.List;
import org.oil.manager.entity.IndicatorWeightDistribution;
import org.oil.manager.entity.RodStringDesignParameter;
import org.oil.manager.entity.RodStructureParameter;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.WellDesignParameter;
import org.oil.manager.service.IndicatorWeightDistributionService;
import org.oil.manager.service.RodStringDesignParameterService;
import org.oil.manager.service.RodStructureParameterService;
import org.oil.manager.service.WellBaseDataService;
import org.oil.manager.service.WellDesignParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/{wellId}/updateProductData", method = { RequestMethod.POST })
	@ResponseBody
	public boolean updateProductData(@PathVariable int wellId,
			@RequestParam String pumpingMachineType,
			@RequestParam double producingOilRate,
			@RequestParam double production, @RequestParam double pumpDiameter,
			@RequestParam double stroke, @RequestParam int bluntTimes,
			@RequestParam double wellHeadCasingPressure,
			@RequestParam double pumpDepth,
			@RequestParam double volumetricMoistureContent,
			@RequestParam double workingFluidLevel,
			@RequestParam double sternTubeLength) {
		System.out.println("enter updateProductData");
		return this.wellBaseDataService.updateProductData(wellId,
				pumpingMachineType, producingOilRate, production, pumpDiameter,
				stroke, bluntTimes, wellHeadCasingPressure, pumpDepth,
				volumetricMoistureContent, workingFluidLevel, sternTubeLength);
	}

	@RequestMapping(value = "/{wellId}/updateFluidPhysicalParameters", method = { RequestMethod.POST })
	@ResponseBody
	public boolean insertFluidPhysicalParameters(@PathVariable int wellId,
			@RequestParam double saturationPressure,
			@RequestParam double reservoirPressure,
			@RequestParam double crudeOilDensity,
			@RequestParam double crudeOilViscosity,
			@RequestParam double formationWaterDensity,
			@RequestParam double gasPhaseRelativeDensity) {
		return this.wellBaseDataService.updateFluidPhysicalParameters(wellId,
				saturationPressure, reservoirPressure, crudeOilDensity,
				crudeOilViscosity, formationWaterDensity,
				gasPhaseRelativeDensity);
	}

	@RequestMapping(value = "/baseData", method = RequestMethod.GET)
	@ResponseBody
	public List<WellBaseData> queryAllWellBaseData() {
		System.out.println("enter queryAllWellBaseData");
		List<WellBaseData> result = this.wellBaseDataService
				.queryAllWellBaseData();
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

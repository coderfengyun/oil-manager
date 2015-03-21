package org.oil.manager.api;

import java.util.List;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.service.IndicatorWeightDistributionService;
import org.oil.manager.service.WellBaseDataService;
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

	@RequestMapping(value = "/{wellId}/updateFluidPhysicalParameter", method = { RequestMethod.POST })
	@ResponseBody
	public boolean updateFluidPhysicalParameter(@PathVariable int wellId,
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

	@RequestMapping(value = "/{wellId}/updateDesignParameter", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean updateDesignParameter(@PathVariable int wellId,
			@RequestParam double producedFluidVolume,
			@RequestParam double moistureRatio,
			@RequestParam double minProducedFluidVolume,
			@RequestParam double minPumpEfficiency) {
		return this.wellBaseDataService.updateWellDesignParameter(wellId,
				producedFluidVolume, moistureRatio, minProducedFluidVolume,
				minPumpEfficiency);
	}

	@RequestMapping(value = "/{wellId}/updateRodStringDesignParameter", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean updateRodStringDesignParameter(@PathVariable int wellId,
			@RequestParam double safetyFactor, @RequestParam byte poleLevel,
			@RequestParam double minRodDiameter) {
		return this.wellBaseDataService.updateRodStringDesignParameter(wellId,
				safetyFactor, poleLevel, minRodDiameter);
	}

	@RequestMapping(value = "/{wellId}/updateRodStructureParameter", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean updateRodStructureParameter(@PathVariable int wellId,
			@RequestParam byte poleLevel, @RequestParam double rodDiameter,
			@RequestParam double rodLength) {
		return this.wellBaseDataService.updateRodStringStructureParameter(
				wellId, poleLevel, rodLength, rodLength);
	}

	@RequestMapping(value = "/{wellId}/updateIndicatorWeightDistribution", method = {
			RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public boolean updateIndicatorWeightDistribution(@PathVariable int wellId,
			@RequestParam String productionCoordination,
			@RequestParam double pumpEffeciency,
			@RequestParam double systemEffeciency,
			@RequestParam double production,
			@RequestParam double econemicBenifits,
			@RequestParam double utilization) {
		return this.wellBaseDataService.updateIndicatorWeightDistribution(
				wellId, productionCoordination, utilization, utilization,
				utilization, utilization, utilization);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<WellBaseData> queryAllWellBaseData() {
		System.out.println("enter queryAllWellBaseData");
		List<WellBaseData> result = this.wellBaseDataService
				.queryAllWellBaseData();
		return result;
	}

}

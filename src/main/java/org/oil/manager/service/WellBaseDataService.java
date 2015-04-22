package org.oil.manager.service;

import java.util.List;
import java.util.Optional;

import org.oil.manager.entity.FluidPhysicalParameter;
import org.oil.manager.entity.IndicatorWeightDistribution;
import org.oil.manager.entity.RodStringDesignParameter;
import org.oil.manager.entity.RodStructureParameter;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.WellDesignParameter;
import org.oil.manager.entity.WellProductData;
import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellBaseDataService extends AbstractService<WellBaseData> {
	@Autowired
	private WellBaseDataRepository wellBaseDataReposity;

	public boolean addAWellBaseData(double wellDepth,
			double casingOutterDiameter, double casingInnerDiameter,
			double reservoirTemperature, double tubingOutterDiameter,
			double tubingInnerDiameter) {
		return this.wellBaseDataReposity.attach(WellBaseData
				.buildWithoutId(wellDepth, casingOutterDiameter,
						casingInnerDiameter, reservoirTemperature,
						tubingOutterDiameter, tubingInnerDiameter));
	}

	public boolean delete(int wellId) {
		Optional<WellBaseData> nullableWell = this.fetchWell(wellId);
		return this.wellBaseDataReposity.detach(nullableWell.get());
	}

	

	public List<WellBaseData> findAll() {
		return this.wellBaseDataReposity.findAll();
	}

	public boolean updateProductData(int wellId, String pumpingMachineType,
			double producingOilRate, double production, double pumpDiameter,
			double stroke, int bluntTimes, double wellHeadCasingPressure,
			double pumpDepth, double volumetricMoistureContent,
			double workingFluidLevel, double sternTubeLength) {
		Optional<WellBaseData> well = fetchWell(wellId);
		well.get().setWellProductData(
				WellProductData.buildWithoutId(pumpingMachineType,
						producingOilRate, production, pumpDiameter, stroke,
						bluntTimes, wellHeadCasingPressure, pumpDepth,
						volumetricMoistureContent, workingFluidLevel,
						sternTubeLength));
		return this.wellBaseDataReposity.update(well.get());
	}

	public boolean updateFluidPhysicalParameters(int wellId,
			double saturationPressure, double reservoirPressure,
			double crudeOilDensity, double crudeOilViscosity,
			double formationWaterDensity, double gasPhaseRelativeDensity) {
		Optional<WellBaseData> well = fetchWell(wellId);
		well.get().setFluidPhysicalParameter(
				FluidPhysicalParameter.buildWithoutId(saturationPressure,
						reservoirPressure, crudeOilDensity, crudeOilViscosity,
						formationWaterDensity, gasPhaseRelativeDensity));
		return this.wellBaseDataReposity.update(well.get());
	}

	public boolean updateWellDesignParameter(int wellId,
			double producedFluidVolume, double moistureRatio,
			double minProducedFluidVolume, double minPumpEfficiency) {
		WellBaseData well = this.fetchWell(wellId).get();
		well.setWellDesignParameter(WellDesignParameter.build(
				producedFluidVolume, moistureRatio, minProducedFluidVolume,
				minPumpEfficiency));
		return this.wellBaseDataReposity.update(well);
	}

	public boolean updateRodStringDesignParameter(int wellId,
			double safetyFactor, byte poleLevel, double minRodDiameter) {
		WellBaseData well = this.fetchWell(wellId).get();
		well.setRodStringDesignParameter(RodStringDesignParameter
				.buildWithoutId(safetyFactor, poleLevel, minRodDiameter));
		return this.wellBaseDataReposity.update(well);
	}

	public boolean updateRodStringStructureParameter(int wellId,
			byte poleLevel, double rodDiameter, double rodLength) {
		WellBaseData well = this.fetchWell(wellId).get();
		well.setRodStructureParameter(RodStructureParameter.buildWithoutId(
				poleLevel, rodDiameter, rodLength));
		return this.wellBaseDataReposity.update(well);
	}

	public boolean updateIndicatorWeightDistribution(int wellId,
			String productionCoordination, double pumpEffeciency,
			double systemEffeciency, double production,
			double econemicBenifits, double utilization) {
		WellBaseData well = this.fetchWell(wellId).get();
		well.setIndicatorWeightDistribution(IndicatorWeightDistribution
				.buildWithoutId(productionCoordination, pumpEffeciency,
						systemEffeciency, production, econemicBenifits,
						utilization));
		return this.wellBaseDataReposity.update(well);
	}
}

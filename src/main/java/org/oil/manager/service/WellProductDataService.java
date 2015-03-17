package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.WellProductData;
import org.oil.manager.repository.WellProductDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellProductDataService {
	@Autowired
	private WellProductDataRepository wellProductDataRepository;

	public boolean addAWellProductData(String pumpingMachineType,
			double producingOilRate, double production, double pumpDiameter,
			double stroke, int bluntTimes, double wellHeadCasingPressure,
			double pumpDepth, double volumetricMoistureContent,
			double workingFluidLevel, double sternTubeLength) {
		return this.wellProductDataRepository.attach(WellProductData
				.buildWithoutId(pumpingMachineType, producingOilRate,
						production, pumpDiameter, stroke, bluntTimes,
						wellHeadCasingPressure, pumpDepth,
						volumetricMoistureContent, workingFluidLevel,
						sternTubeLength));
	}

	public List<WellProductData> findAll() {
		return this.wellProductDataRepository.findAll();
	}
}

package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.WellPressureDistribution;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.repository.WellBaseDataRepository;
import org.oil.manager.repository.WellPressureDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellPressureDistributionService extends
		AbstractService<WellPressureDistribution> {
	@Autowired
	private WellPressureDistributionRepository repo;
	@Autowired
	private WellBaseDataRepository wellRepo;

	@Override
	public List<WellPressureDistribution> findAll() {
		return this.repo.findAll();
	}

	public boolean add(double pumpDepth, double sinkingPressure,
			double fulfillCoefficient, int wellId) {
		WellBaseData well = this.wellRepo.find(wellId);
		return this.repo.attach(WellPressureDistribution.buildWithoutId(
				pumpDepth, sinkingPressure, fulfillCoefficient, well));
	}

	public List<WellPressureDistribution> findAllByWellId(int wellId) {
		WellBaseData well = this.wellRepo.find(wellId);
		return this.repo.findAllBy(WellPressureDistribution
				.createEqualsToWellIdSpecification(well));
	}
}

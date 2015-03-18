package org.oil.manager.service;

import java.util.List;
import org.oil.manager.entity.IndicatorWeightDistribution;
import org.oil.manager.repository.IndicatorWeightDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndicatorWeightDistributionService extends
		AbstractService<IndicatorWeightDistribution> {
	@Autowired
	private IndicatorWeightDistributionRepository repo;

	public boolean addAIndicatorWeightDistribution(String productionCoordination, double pumpEffeciency,
			double systemEffeciency, double production,
			double econemicBenifits, double utilization) {
		return this.repo.attach(IndicatorWeightDistribution.buildWithoutId(
				productionCoordination, pumpEffeciency, systemEffeciency,
				production, econemicBenifits, utilization));
	}

	@Override
	public List<IndicatorWeightDistribution> findAll() {
		return this.repo.findAll();
	}

}

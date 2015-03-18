package org.oil.manager.repository;

import java.util.List;

import org.oil.manager.entity.IndicatorWeightDistribution;
import org.springframework.stereotype.Component;

@Component
public class IndicatorWeightDistributionRepository extends
		AbstractRepository<IndicatorWeightDistribution> {

	@Override
	public boolean attach(IndicatorWeightDistribution dumEntity) {
		return attachCore(dumEntity);
	}

	@Override
	public List<IndicatorWeightDistribution> findAll() {
		return this.findAll(IndicatorWeightDistribution.class);
	}

}

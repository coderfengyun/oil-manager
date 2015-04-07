package org.oil.manager.repository;

import org.oil.manager.entity.WellPressureDistribution;
import org.springframework.stereotype.Component;

@Component
public class WellPressureDistributionRepository extends
		AbstractRepository<WellPressureDistribution> {

	WellPressureDistributionRepository() {
		super(WellPressureDistribution.class);
	}

}

package org.oil.manager.repository;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.oil.manager.entity.WellPressureDistribution;
import org.springframework.stereotype.Component;

@Component
public class WellPressureDistributionRepository extends
		AbstractRepository<WellPressureDistribution> {

	@Override
	public List<WellPressureDistribution> findAll() {
		return this.findAll(WellPressureDistribution.class);
	}

	@Override
	public List<WellPressureDistribution> findAllBy(Criterion specification) {
		return this
				.findAllByCore(specification, WellPressureDistribution.class);
	}

}

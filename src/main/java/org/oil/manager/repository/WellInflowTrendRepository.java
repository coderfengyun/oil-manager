package org.oil.manager.repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.oil.manager.entity.WellInflowTrend;
import org.springframework.stereotype.Component;

@Component
public class WellInflowTrendRepository extends
		AbstractRepository<WellInflowTrend> {

	@Override
	public boolean attach(WellInflowTrend dumEntity) {
		return attachCore(dumEntity);
	}

	@Override
	public List<WellInflowTrend> findAll() {
		return Collections.emptyList();
	}

	@Override
	public List<WellInflowTrend> findAllBy(Criterion specification) {
		return findAllByCore(specification, WellInflowTrend.class);
	}

}

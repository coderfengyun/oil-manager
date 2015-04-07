package org.oil.manager.repository;

import org.oil.manager.entity.WellInflowTrend;
import org.springframework.stereotype.Component;

@Component
public class WellInflowTrendRepository extends
		AbstractRepository<WellInflowTrend> {

	WellInflowTrendRepository() {
		super(WellInflowTrend.class);
	}

}

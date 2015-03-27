package org.oil.manager.repository;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.oil.manager.entity.PreferredPlan;
import org.springframework.stereotype.Component;

@Component
public class PreferredPlanRepository extends AbstractRepository<PreferredPlan> {

	@Override
	public boolean attach(PreferredPlan dumEntity) {
		return this.attachCore(dumEntity);
	}

	@Override
	public List<PreferredPlan> findAll() {
		return this.findAll(PreferredPlan.class);
	}

	@Override
	public List<PreferredPlan> findAllBy(Criterion specification) {
		return this.findAllByCore(specification, PreferredPlan.class);
	}

}

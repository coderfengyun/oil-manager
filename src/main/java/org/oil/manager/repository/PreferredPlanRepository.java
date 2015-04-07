package org.oil.manager.repository;

import org.oil.manager.entity.PreferredPlan;
import org.springframework.stereotype.Component;

@Component
public class PreferredPlanRepository extends AbstractRepository<PreferredPlan> {

	public PreferredPlanRepository() {
		super(PreferredPlan.class);
	}

}

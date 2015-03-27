package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.repository.PreferredPlanRepository;
import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreferredPlanService extends AbstractService<PreferredPlan> {
	@Autowired
	private PreferredPlanRepository repo;
	@Autowired
	private WellBaseDataRepository wellRepo;

	@Override
	public List<PreferredPlan> findAll() {
		return this.repo.findAll();
	}

	public List<PreferredPlan> findAllByWellId(int wellId) {
		WellBaseData well = this.wellRepo.find(wellId);
		return this.repo.findAllBy(PreferredPlan
				.createEqualsToWellIdSpecification(well));
	}

	public boolean add(int wellId, double econemicBenifits, double production,
			double pumpEffeciency, double systemEffeciency, double utilization) {
		WellBaseData well = this.wellRepo.find(wellId);
		return this.repo.attach(PreferredPlan
				.buildWithoutId(econemicBenifits, production, pumpEffeciency,
						systemEffeciency, utilization, well));
	}
}

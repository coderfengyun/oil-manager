package org.oil.manager.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.valueobject.PlanedScoreCalculator;
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

	public boolean add(int wellId, double pumpDepth, double econemicBenifits,
			double production, double pumpEffeciency, double systemEffeciency,
			double utilization) {
		WellBaseData well = this.wellRepo.find(wellId);
		return this.repo.attach(PreferredPlan.buildWithoutId(pumpDepth,
				econemicBenifits, production, pumpEffeciency, systemEffeciency,
				utilization, well));
	}

	public Map<PreferredPlan, Double> calculateScore(int wellId) {
		WellBaseData well = this.wellRepo.find(wellId);
		List<PreferredPlan> allPlanInWell = this.repo.findAllBy(PreferredPlan
				.createEqualsToWellIdSpecification(well));
		Map<PreferredPlan, Double> scoreMap = new PlanedScoreCalculator(
				allPlanInWell, Arrays.asList(10.0, 9.0, 8.0, 7.0, 6.0))
				.calculateScore();
		return scoreMap;
	}

}

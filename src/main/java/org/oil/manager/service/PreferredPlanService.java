package org.oil.manager.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

	public List<PreferredPlan> findAllByWellId(int wellId) {
		Optional<WellBaseData> well = this.wellRepo.find(wellId);
		if (!well.isPresent()) {
			return Collections.emptyList();
		}
		return this.repo.findAllBy(PreferredPlan
				.createEqualsToWellIdSpecification(well.get()));
	}

	public boolean add(int wellId, double pumpDepth, double econemicBenifits,
			double production, double pumpEffeciency, double systemEffeciency,
			double utilization) {
		Optional<WellBaseData> nullableWell = this.wellRepo.find(wellId);
		if (nullableWell.isPresent()) {
			return false;
		}
		return this.repo.attach(PreferredPlan.buildWithoutId(pumpDepth,
				econemicBenifits, production, pumpEffeciency, systemEffeciency,
				utilization, nullableWell.get()));
	}

	public Map<PreferredPlan, Double> calculateScore(int wellId) {
		Optional<WellBaseData> nullableWell = this.wellRepo.find(wellId);
		if (nullableWell.isPresent()) {
			return Collections.emptyMap();
		}
		List<PreferredPlan> allPlanInWell = this.repo.findAllBy(PreferredPlan
				.createEqualsToWellIdSpecification(nullableWell.get()));
		Map<PreferredPlan, Double> scoreMap = new PlanedScoreCalculator(
				allPlanInWell, Arrays.asList(10.0, 9.0, 8.0, 7.0, 6.0))
				.calculateScore();
		return scoreMap;
	}
}

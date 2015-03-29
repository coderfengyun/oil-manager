package org.pol.manager.valueobject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.entity.valueobject.PlanedScoreCalculator;

public class Test_PlanedScoreCalculator {

	@Test
	public void test() {
		List<PreferredPlan> plans = new LinkedList<PreferredPlan>();
		for (double i = 1.0; i < 6.0; i = i + 1) {
			plans.add(PreferredPlan.buildWithoutId(i, i, i, i, i, i, null));
		}
		List<Double> bonusScores = Arrays.asList(10.0, 9.0, 8.0, 7.0, 6.0);
		Map<PreferredPlan, Double> result = new PlanedScoreCalculator(plans,
				bonusScores).calculateScore();
		for (PreferredPlan item : plans) {
			System.out.println(result.get(item));
		}
	}
}

package org.oil.manager.valueobject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.entity.valueobject.PlanedScoreCalculator;

public class Test_PlanedScoreCalculator {

	@Test
	public void testWith_$P1_PlanCount_LT_$P2_BonusScoreCount_EQ_FIVE() {
		List<PreferredPlan> plans = buildWith(4.0);
		List<Double> bonusScores = Arrays.asList(10.0, 9.0, 8.0, 7.0, 6.0);
		Map<PreferredPlan, Double> result = new PlanedScoreCalculator(plans,
				bonusScores).calculateScore();
		for (PreferredPlan item : plans) {
			System.out.println(result.get(item));
		}
	}

	private List<PreferredPlan> buildWith(double size) {
		List<PreferredPlan> plans = new LinkedList<PreferredPlan>();
		for (double i = 0; i < size; i++) {
			plans.add(PreferredPlan.buildWithoutId(i, i, i, i, i, i, null));
		}
		return plans;
	}

	@Test
	public void testWith_$P1_PlanCount_GT_$P2_BonusScoreCount_EQ_FIVE() {
		List<PreferredPlan> plans = buildWith(7.0);
		List<Double> bonusScores = Arrays.asList(10.0, 9.0, 8.0, 7.0, 6.0);
		Map<PreferredPlan, Double> result = new PlanedScoreCalculator(plans,
				bonusScores).calculateScore();
		for (PreferredPlan item : plans) {
			System.out.println(result.get(item));
		}
	}
}

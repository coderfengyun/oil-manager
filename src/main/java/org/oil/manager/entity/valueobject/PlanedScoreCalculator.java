package org.oil.manager.entity.valueobject;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.oil.manager.entity.PreferredPlan;

public class PlanedScoreCalculator {
	private List<PreferredPlan> plans;
	private List<Double> baseScore;

	/**
	 * 
	 * @param plans
	 * @param baseScore
	 *            , indicate the score as its order.
	 */
	public PlanedScoreCalculator(List<PreferredPlan> plans,
			List<Double> baseScore) {
		this.plans = plans;
		this.baseScore = baseScore;
	}

	public Map<PreferredPlan, Double> calculateScore() {
		Map<PreferredPlan, Double> result = new HashMap<PreferredPlan, Double>();
		for (String propertyName : PreferredPlan.propertiesToScore()) {
			Map<PreferredPlan, Double> singlePropertyScore = calculateScoreForProperty(
					this.plans, propertyName);
			if (result.size() == 0) {
				result.putAll(singlePropertyScore);
			} else {
				for (PreferredPlan plan : result.keySet()) {
					result.put(plan,
							result.get(plan) + singlePropertyScore.get(plan));
				}
			}
		}
		return result;
	}

	private Map<PreferredPlan, Double> calculateScoreForProperty(
			List<PreferredPlan> plans, final String propertyName) {
		try {
			final Field field = PreferredPlan.class
					.getDeclaredField(propertyName);
			field.setAccessible(true);
			Collections.sort(plans, new Comparator<PreferredPlan>() {
				public int compare(PreferredPlan o1, PreferredPlan o2) {
					double diference;
					try {
						diference = field.getDouble(o1) - field.getDouble(o2);
						return diference > 0 ? -1 : (diference == 0 ? 0 : 1);
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			});
			List<Double> originValues = new LinkedList<Double>();
			for (PreferredPlan plan : plans) {
				originValues.add(field.getDouble(plan));
			}
			return calculateScoreByTheBaseScore(plans, originValues);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private Map<PreferredPlan, Double> calculateScoreByTheBaseScore(
			List<PreferredPlan> orderedPlan, List<Double> originValues) {
		Map<PreferredPlan, Double> result = new HashMap<PreferredPlan, Double>();
		List<Double> bonusScores = new LinkedList<Double>(this.baseScore);
		if (orderedPlan.size() > bonusScores.size()) {
			int difference = orderedPlan.size() - bonusScores.size();
			for (int i = 0; i < difference; i++) {
				bonusScores.add(0d);
			}
		}
		for (int i = 0; i < orderedPlan.size(); i++) {
			PreferredPlan item = orderedPlan.get(i);
			Double bonusScore = bonusScores.get(i);
			result.put(item, bonusScore * originValues.get(i));
		}
		return result;
	}
}

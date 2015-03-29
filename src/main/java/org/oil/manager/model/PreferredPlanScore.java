package org.oil.manager.model;

public class PreferredPlanScore {
	private int id;
	private double pumpDepth;
	private double score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPumpDepth() {
		return pumpDepth;
	}

	public void setPumpDepth(double pumpDepth) {
		this.pumpDepth = pumpDepth;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static PreferredPlanScore build(int id, double pumpDepth,
			double score) {
		PreferredPlanScore result = new PreferredPlanScore();
		result.setId(id);
		result.setPumpDepth(pumpDepth);
		result.setScore(score);
		return result;
	}
}

package org.oil.manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name = "pressureDistribution")
public class WellPressureDistribution implements Aggregate {
	private static final String WELL_COLUMN_NAME = "well";
	private int id;
	private double pumpDepth;
	private double sinkingPressure;
	private double fulfillCoefficient;
	private WellBaseData well;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public double getSinkingPressure() {
		return sinkingPressure;
	}

	public void setSinkingPressure(double sinkingPressure) {
		this.sinkingPressure = sinkingPressure;
	}

	public double getFulfillCoefficient() {
		return fulfillCoefficient;
	}

	public void setFulfillCoefficient(double fulfillCoefficient) {
		this.fulfillCoefficient = fulfillCoefficient;
	}

	@ManyToOne
	@JoinColumn(name = "wellId", nullable = false)
	public WellBaseData getWell() {
		return well;
	}

	public void setWell(WellBaseData well) {
		this.well = well;
	}

	public static Criterion createEqualsToWellIdSpecification(WellBaseData well) {
		return Restrictions.eq(WELL_COLUMN_NAME, well);
	}

	public static WellPressureDistribution buildWithoutId(double pumpDepth,
			double sinkingPressure, double fulfillCoefficient, WellBaseData well) {
		WellPressureDistribution result = new WellPressureDistribution();
		result.setFulfillCoefficient(fulfillCoefficient);
		result.setPumpDepth(pumpDepth);
		result.setSinkingPressure(sinkingPressure);
		result.setWell(well);
		return result;
	}
}

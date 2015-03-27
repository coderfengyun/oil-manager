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
@Table(name = "preferredPlan")
public class PreferredPlan implements Aggregate {
	private static final String WELL_COLUMN_NAME = "well";
	private int id;
	private double pumpEffeciency;
	private double systemEffeciency;
	private double production;
	private double econemicBenifits;
	private double utilization;
	private WellBaseData well;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPumpEffeciency() {
		return pumpEffeciency;
	}

	public void setPumpEffeciency(double pumpEffeciency) {
		this.pumpEffeciency = pumpEffeciency;
	}

	public double getSystemEffeciency() {
		return systemEffeciency;
	}

	public void setSystemEffeciency(double systemEffeciency) {
		this.systemEffeciency = systemEffeciency;
	}

	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	public double getEconemicBenifits() {
		return econemicBenifits;
	}

	public void setEconemicBenifits(double econemicBenifits) {
		this.econemicBenifits = econemicBenifits;
	}

	public double getUtilization() {
		return utilization;
	}

	public void setUtilization(double utilization) {
		this.utilization = utilization;
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

	public static PreferredPlan buildWithoutId(double econemicBenifits,
			double production, double pumpEffeciency, double systemEffeciency,
			double utilization, WellBaseData well) {
		PreferredPlan result = new PreferredPlan();
		result.setEconemicBenifits(econemicBenifits);
		result.setProduction(production);
		result.setPumpEffeciency(pumpEffeciency);
		result.setSystemEffeciency(systemEffeciency);
		result.setUtilization(utilization);
		result.setWell(well);
		return result;
	}
}

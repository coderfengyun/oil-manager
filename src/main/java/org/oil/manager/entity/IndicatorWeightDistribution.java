package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indicatorWeightDistribution")
public class IndicatorWeightDistribution implements Aggregate {
	private int id;
	private String productionCoordination;
	private double pumpEffeciency;
	private double systemEffeciency;
	private double production;
	private double econemicBenifits;
	private double utilization;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "productionCoordination")
	public String getProductionCoordination() {
		return productionCoordination;
	}

	public void setProductionCoordination(String productionCoordination) {
		this.productionCoordination = productionCoordination;
	}

	@Column(name = "pumpEffeciency")
	public double getPumpEffeciency() {
		return pumpEffeciency;
	}

	public void setPumpEffeciency(double pumpEffeciency) {
		this.pumpEffeciency = pumpEffeciency;
	}

	@Column(name = "systemEffeciency")
	public double getSystemEffeciency() {
		return systemEffeciency;
	}

	public void setSystemEffeciency(double systemEffeciency) {
		this.systemEffeciency = systemEffeciency;
	}

	@Column(name = "production")
	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	@Column(name = "econemicBenifits")
	public double getEconemicBenifits() {
		return econemicBenifits;
	}

	public void setEconemicBenifits(double econemicBenifits) {
		this.econemicBenifits = econemicBenifits;
	}

	@Column(name = "utilization")
	public double getUtilization() {
		return utilization;
	}

	public void setUtilization(double utilization) {
		this.utilization = utilization;
	}

	public static IndicatorWeightDistribution buildWithoutId(
			String productionCoordination, double pumpEffeciency,
			double systemEffeciency, double production,
			double econemicBenifits, double utilization) {
		IndicatorWeightDistribution result = new IndicatorWeightDistribution();
		result.setEconemicBenifits(econemicBenifits);
		result.setProduction(production);
		result.setProductionCoordination(productionCoordination);
		result.setPumpEffeciency(pumpEffeciency);
		result.setSystemEffeciency(systemEffeciency);
		result.setUtilization(utilization);
		return result;
	}
}

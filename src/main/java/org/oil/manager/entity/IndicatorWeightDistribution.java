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
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "productionCoordination", nullable = false)
	public String getProductionCoordination() {
		return productionCoordination;
	}

	public void setProductionCoordination(String productionCoordination) {
		this.productionCoordination = productionCoordination;
	}

	@Column(name = "pumpEffeciency", nullable = false)
	public double getPumpEffeciency() {
		return pumpEffeciency;
	}

	public void setPumpEffeciency(double pumpEffeciency) {
		this.pumpEffeciency = pumpEffeciency;
	}

	@Column(name = "systemEffeciency", nullable = false)
	public double getSystemEffeciency() {
		return systemEffeciency;
	}

	public void setSystemEffeciency(double systemEffeciency) {
		this.systemEffeciency = systemEffeciency;
	}

	@Column(name = "production", nullable = false)
	public double getProduction() {
		return production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

	@Column(name = "econemicBenifits", nullable = false)
	public double getEconemicBenifits() {
		return econemicBenifits;
	}

	public void setEconemicBenifits(double econemicBenifits) {
		this.econemicBenifits = econemicBenifits;
	}

	@Column(name = "utilization", nullable = false)
	public double getUtilization() {
		return utilization;
	}

	public void setUtilization(double utilization) {
		this.utilization = utilization;
	}

}

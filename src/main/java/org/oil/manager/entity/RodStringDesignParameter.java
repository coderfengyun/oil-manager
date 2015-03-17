package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rodStringDesignParameter")
public class RodStringDesignParameter implements Aggregate {
	private int id;
	private double safetyFactor;
	private byte poleLevel;
	private double minRodDiameter;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "safetyFactor", nullable = false)
	public double getSafetyFactor() {
		return safetyFactor;
	}

	public void setSafetyFactor(double safetyFactor) {
		this.safetyFactor = safetyFactor;
	}

	@Column(name = "poleLevel", nullable = false)
	public byte getPoleLevel() {
		return poleLevel;
	}

	public void setPoleLevel(byte poleLevel) {
		this.poleLevel = poleLevel;
	}

	@Column(name = "minRodDiameter", nullable = false)
	public double getMinRodDiameter() {
		return minRodDiameter;
	}

	public void setMinRodDiameter(double minRodDiameter) {
		this.minRodDiameter = minRodDiameter;
	}

	public static RodStringDesignParameter buildWithoutId(double safetyFactor,
			byte poleLevel, double minRodDiameter) {
		RodStringDesignParameter result = new RodStringDesignParameter();
		result.setSafetyFactor(safetyFactor);
		result.setPoleLevel(poleLevel);
		result.setMinRodDiameter(minRodDiameter);
		return result;
	}
}

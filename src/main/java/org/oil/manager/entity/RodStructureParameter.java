package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wellBaseData")
public class RodStructureParameter {
	private int id;
	private byte poleLevel;
	private double rodDiameter;
	private double rodLength;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "poleLevel", nullable = false)
	public byte getPoleLevel() {
		return poleLevel;
	}

	public void setPoleLevel(byte poleLevel) {
		this.poleLevel = poleLevel;
	}

	@Column(name = "rodDiameter", nullable = false)
	public double getRodDiameter() {
		return rodDiameter;
	}

	public void setRodDiameter(double rodDiameter) {
		this.rodDiameter = rodDiameter;
	}

	@Column(name = "rodLength", nullable = false)
	public double getRodLength() {
		return rodLength;
	}

	public void setRodLength(double rodLength) {
		this.rodLength = rodLength;
	}

	public static RodStructureParameter buildWithoutId(byte poleLevel,
			double rodDiameter, double rodLength) {
		RodStructureParameter result = new RodStructureParameter();
		result.setPoleLevel(poleLevel);
		result.setRodDiameter(rodDiameter);
		result.setRodLength(rodLength);
		return result;
	}
}

package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rodStructureParameter")
public class RodStructureParameter implements Aggregate {
	private int id;
	private byte poleLevel;
	private double rodDiameter;
	private double rodLength;
	private WellBaseData wellBaseData;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "poleLevel")
	public byte getPoleLevel() {
		return poleLevel;
	}

	public void setPoleLevel(byte poleLevel) {
		this.poleLevel = poleLevel;
	}

	@Column(name = "rodDiameter")
	public double getRodDiameter() {
		return rodDiameter;
	}

	public void setRodDiameter(double rodDiameter) {
		this.rodDiameter = rodDiameter;
	}

	@Column(name = "rodLength")
	public double getRodLength() {
		return rodLength;
	}

	public void setRodLength(double rodLength) {
		this.rodLength = rodLength;
	}

	@OneToOne(mappedBy = "rodStructureParameter")
	public WellBaseData getWellBaseData() {
		return wellBaseData;
	}

	public void setWellBaseData(WellBaseData wellBaseData) {
		this.wellBaseData = wellBaseData;
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

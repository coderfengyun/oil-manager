package org.oil.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wellDesignParameter")
public class WellDesignParameter implements Aggregate {
	private int id;
	private double producedFluidVolume;
	private double moistureRatio;
	private double minProducedFluidVolume;
	private double minPumpEfficiency;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "producedFluidVolume", nullable = false)
	public double getProducedFluidVolume() {
		return producedFluidVolume;
	}

	public void setProducedFluidVolume(double producedFluidVolume) {
		this.producedFluidVolume = producedFluidVolume;
	}

	@Column(name = "moistureRatio", nullable = false)
	public double getMoistureRatio() {
		return moistureRatio;
	}

	public void setMoistureRatio(double moistureRatio) {
		this.moistureRatio = moistureRatio;
	}

	@Column(name = "minProducedFluidVolume", nullable = false)
	public double getMinProducedFluidVolume() {
		return minProducedFluidVolume;
	}

	public void setMinProducedFluidVolume(double minProducedFluidVolume) {
		this.minProducedFluidVolume = minProducedFluidVolume;
	}

	@Column(name = "minPumpEfficiency", nullable = false)
	public double getMinPumpEfficiency() {
		return minPumpEfficiency;
	}

	public void setMinPumpEfficiency(double minPumpEfficiency) {
		this.minPumpEfficiency = minPumpEfficiency;
	}

	public static WellDesignParameter build(double producedFluidVolume,
			double moistureRatio, double minProducedFluidVolume,
			double minPumpEfficiency) {
		WellDesignParameter result = new WellDesignParameter();
		result.setMinProducedFluidVolume(minProducedFluidVolume);
		result.setMinPumpEfficiency(minPumpEfficiency);
		result.setMoistureRatio(moistureRatio);
		result.setProducedFluidVolume(producedFluidVolume);
		return result;
	}

}

package org.oil.manager.entity;

import javax.persistence.Column;
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
@Table(name = "wellInflowTrend")
public class WellInflowTrend implements Aggregate {
	private static final String WELL_COLUMN_NAME = "well";
	private int id;
	private double producedFluidVolume;
	private double wellBotomFlowPressure;
	private WellBaseData well;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getProducedFluidVolume() {
		return producedFluidVolume;
	}

	public void setProducedFluidVolume(double producedFluidVolume) {
		this.producedFluidVolume = producedFluidVolume;
	}

	public double getWellBotomFlowPressure() {
		return wellBotomFlowPressure;
	}

	public void setWellBotomFlowPressure(double wellBotomFlowPressure) {
		this.wellBotomFlowPressure = wellBotomFlowPressure;
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

	public static WellInflowTrend buildWithoutId(WellBaseData well,
			double producedFluidVolume, double wellBotomFlowPressure) {
		WellInflowTrend result = new WellInflowTrend();
		result.setProducedFluidVolume(producedFluidVolume);
		result.setWellBotomFlowPressure(wellBotomFlowPressure);
		result.setWell(well);
		return result;
	}
}

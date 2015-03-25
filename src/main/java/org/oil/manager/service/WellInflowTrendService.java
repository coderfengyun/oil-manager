package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.WellInflowTrend;
import org.oil.manager.repository.WellBaseDataRepository;
import org.oil.manager.repository.WellInflowTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellInflowTrendService {
	@Autowired
	private WellBaseDataRepository wellBaseDataRepo;
	@Autowired
	private WellInflowTrendRepository repo;

	public boolean addAInflowTrend(int wellId, double producedFluidVolume,
			double wellBotomFlowPressure) {
		WellBaseData well = this.wellBaseDataRepo.find(wellId);
		return this.repo.attach(WellInflowTrend.buildWithoutId(well,
				producedFluidVolume, wellBotomFlowPressure));
	}

	public List<WellInflowTrend> queryAllByWellId(int wellId) {
		return this.repo.findAllBy(WellInflowTrend
				.createEqualsToWellIdSpecification(this.wellBaseDataRepo
						.find(wellId)));
	}
}
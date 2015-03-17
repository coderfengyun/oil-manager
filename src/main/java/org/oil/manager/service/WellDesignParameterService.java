package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.WellDesignParameter;
import org.oil.manager.repository.WellDesignParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WellDesignParameterService {
	@Autowired
	private WellDesignParameterRepository repo;

	public boolean addAWellDesignParameter(double producedFluidVolume,
			double moistureRatio, double minProducedFluidVolume,
			double minPumpEfficiency) {
		return this.repo.attach(WellDesignParameter.build(producedFluidVolume,
				moistureRatio, minProducedFluidVolume, minPumpEfficiency));
	}

	public List<WellDesignParameter> findAll() {
		return this.repo.findAll();
	}
}

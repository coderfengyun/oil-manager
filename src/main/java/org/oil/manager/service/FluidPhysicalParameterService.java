package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.FluidPhysicalParameter;
import org.oil.manager.repository.FluidPhysicalParameterRepository;
import org.springframework.stereotype.Component;

@Component
public class FluidPhysicalParameterService {
	private FluidPhysicalParameterRepository repo;

	public boolean addAFluidPhysicalParameter(double saturationPressure,
			double reservoirPressure, double crudeOilDensity,
			double crudeOilViscosity, double formationWaterDensity,
			double gasPhaseRelativeDensity) {
		return this.repo.attatch(FluidPhysicalParameter.buildWithoutId(
				saturationPressure, reservoirPressure, crudeOilDensity,
				crudeOilViscosity, formationWaterDensity,
				gasPhaseRelativeDensity));
	}

	public List<FluidPhysicalParameter> findAll() {
		return this.repo.findAll();
	}
}

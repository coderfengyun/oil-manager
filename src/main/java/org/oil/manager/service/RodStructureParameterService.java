package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.RodStructureParameter;
import org.oil.manager.repository.RodStructureParameterRepository;
import org.springframework.stereotype.Component;

@Component
public class RodStructureParameterService extends
		AbstractService<RodStructureParameter> {
	private RodStructureParameterRepository repo;

	public boolean addARodStructureParameter(byte poleLevel, double rodDiameter, double rodLength) {
		return this.repo.attach(RodStructureParameter.buildWithoutId(poleLevel,
				rodDiameter, rodLength));
	}

	@Override
	public List<RodStructureParameter> findAll() {
		return this.repo.findAll();
	}
}

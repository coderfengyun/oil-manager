package org.oil.manager.service;

import java.util.List;

import org.oil.manager.entity.RodStringDesignParameter;
import org.oil.manager.repository.RodStrinDesignParameterRepository;
import org.springframework.stereotype.Component;

@Component
public class RodStringDesignParameterService {
	private RodStrinDesignParameterRepository repo;

	public boolean addARodStringDesignParameter(double safetyFactor,
			byte poleLevel, double minRodDiameter) {
		return this.repo.attach(RodStringDesignParameter.buildWithoutId(
				safetyFactor, poleLevel, minRodDiameter));
	}

	public List<RodStringDesignParameter> findAll() {
		return this.repo.findAll();
	}
}

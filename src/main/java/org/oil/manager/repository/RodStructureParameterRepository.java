package org.oil.manager.repository;

import java.util.List;

import org.oil.manager.entity.Aggregate;
import org.oil.manager.entity.RodStructureParameter;
import org.springframework.stereotype.Component;

@Component
public class RodStructureParameterRepository extends
		AbstractRepository<RodStructureParameter> {
	public boolean attach(Aggregate dumEntity) {
		return attachCore(dumEntity);
	}

	public List<RodStructureParameter> findAll() {
		return findAll(RodStructureParameter.class);
	}
}

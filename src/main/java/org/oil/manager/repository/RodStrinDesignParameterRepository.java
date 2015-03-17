package org.oil.manager.repository;

import java.util.List;

import org.oil.manager.entity.Aggregate;
import org.oil.manager.entity.RodStringDesignParameter;
import org.springframework.stereotype.Component;

@Component
public class RodStrinDesignParameterRepository extends
		AbstractRepository<RodStringDesignParameter> {
	public boolean attach(Aggregate dumEntity) {
		return attachCore(dumEntity);
	}

	public List<RodStringDesignParameter> findAll() {
		return findAll(RodStringDesignParameter.class);
	}
}

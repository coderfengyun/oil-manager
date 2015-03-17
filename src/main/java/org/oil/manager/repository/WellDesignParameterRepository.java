package org.oil.manager.repository;

import java.util.List;
import org.oil.manager.entity.WellDesignParameter;
import org.springframework.stereotype.Component;

@Component
public class WellDesignParameterRepository extends
		AbstractRepository<WellDesignParameter> {
	public boolean attach(WellDesignParameter dumEntity) {
		return attachCore(dumEntity);
	}

	public List<WellDesignParameter> findAll() {
		return this.findAll(WellDesignParameter.class);
	}
}

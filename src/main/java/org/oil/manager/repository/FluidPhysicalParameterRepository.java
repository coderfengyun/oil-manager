package org.oil.manager.repository;

import java.util.List;
import org.oil.manager.entity.FluidPhysicalParameter;
import org.springframework.stereotype.Component;

@Component
public class FluidPhysicalParameterRepository extends
		AbstractRepository<FluidPhysicalParameter> {
	public boolean attach(FluidPhysicalParameter dumEntity) {
		return attachCore(dumEntity);
	}

	public List<FluidPhysicalParameter> findAll() {
		return findAll(FluidPhysicalParameter.class);
	}

}

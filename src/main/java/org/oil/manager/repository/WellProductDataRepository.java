package org.oil.manager.repository;

import java.util.List;
import org.oil.manager.entity.WellProductData;
import org.springframework.stereotype.Component;

@Component
public class WellProductDataRepository extends
		AbstractRepository<WellProductData> {
	public boolean attach(WellProductData dumEntity) {
		return attachCore(dumEntity);
	}

	public List<WellProductData> findAll() {
		return findAll(WellProductData.class);
	}
}

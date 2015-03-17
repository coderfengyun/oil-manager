package org.oil.manager.repository;

import java.util.List;
import org.oil.manager.entity.WellBaseData;
import org.springframework.stereotype.Component;

@Component
public class WellBaseDataRepository extends AbstractRepository<WellBaseData> {

	public boolean attach(WellBaseData wellBaseData) {
		return this.attachCore(wellBaseData);
	}

	public List<WellBaseData> findAll() {
		return findAll(WellBaseData.class);
	}
}

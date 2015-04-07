package org.oil.manager.repository;

import org.oil.manager.entity.WellBaseData;
import org.springframework.stereotype.Component;

@Component
public class WellBaseDataRepository extends AbstractRepository<WellBaseData> {

	WellBaseDataRepository() {
		super(WellBaseData.class);
	}

}

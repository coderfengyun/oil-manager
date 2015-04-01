package org.oil.manager.repository;

import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.oil.manager.entity.WellBaseData;
import org.springframework.stereotype.Component;

@Component
public class WellBaseDataRepository extends AbstractRepository<WellBaseData> {

	public List<WellBaseData> findAll() {
		return findAll(WellBaseData.class);
	}

	public WellBaseData find(int id) {
		return find(id, WellBaseData.class);
	}

	public boolean update(WellBaseData well) {
		return updateCore(well);
	}

	@Override
	public List<WellBaseData> findAllBy(Criterion specification) {
		return Collections.emptyList();
	}

}

package org.oil.manager.repository;

import org.oil.manager.entity.TestEntity;
import org.oil.manager.repository.AbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class NoSetterRepository extends AbstractRepository<TestEntity> {

	public NoSetterRepository() {
		super(TestEntity.class);
	}

}

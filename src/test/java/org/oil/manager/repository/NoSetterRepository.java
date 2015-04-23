package org.oil.manager.repository;

import org.oil.manager.entity.compositeid.EntityWithCompositeId;
import org.oil.manager.repository.AbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class NoSetterRepository extends AbstractRepository<EntityWithCompositeId> {

	public NoSetterRepository() {
		super(EntityWithCompositeId.class);
	}

}

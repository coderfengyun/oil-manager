package org.oil.manager.jpa;

import org.oil.manager.repository.AbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class DealRepository extends AbstractRepository<Deal> {

	DealRepository() {
		super(Deal.class);
	}

}

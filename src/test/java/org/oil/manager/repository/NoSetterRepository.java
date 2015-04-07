package org.oil.manager.repository;

import org.oil.manager.entity.NoSetter;
import org.oil.manager.repository.AbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class NoSetterRepository extends AbstractRepository<NoSetter> {

	public NoSetterRepository() {
		super(NoSetter.class);
	}

}

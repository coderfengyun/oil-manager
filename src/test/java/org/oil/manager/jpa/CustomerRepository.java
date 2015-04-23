package org.oil.manager.jpa;

import org.oil.manager.repository.AbstractRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository extends AbstractRepository<Customer> {

	protected CustomerRepository() {
		super(Customer.class);
	}

}

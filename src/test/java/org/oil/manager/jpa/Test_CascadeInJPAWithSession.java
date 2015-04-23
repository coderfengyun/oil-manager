package org.oil.manager.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Test_CascadeInJPAWithSession {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DealRepository dealRepository;

	@Test
	public void testCascadeUpdate() throws NoEnoughBalaceException {
		long initiatorId = 1, targetId = 2, dealId = 3, originBalance = 1000, dealAmount = 200;
		// prepare, delete mayde conflict
		clearUpCollision(initiatorId, targetId, dealId);
		// contruct parameters will be used
		Customer iniator = new Customer(initiatorId, "iniator", originBalance);
		this.customerRepository.attach(iniator);
		Customer target = new Customer(targetId, "target", originBalance);
		this.customerRepository.attach(target);

		Deal deal = new Deal(dealId, iniator, target, dealAmount);
		assertTrue(this.dealRepository.attach(deal));
		// Execute the begin deal
		deal.makeItHappen();
		assertTrue(this.dealRepository.update(deal));
		assertEquals(originBalance - dealAmount, (long) iniator.getBalance());
		assertEquals(originBalance + dealAmount, (long) target.getBalance());
		assertEquals(originBalance - dealAmount, (long) this.customerRepository
				.find(initiatorId).get().getBalance());
		assertEquals(originBalance + dealAmount, (long) this.customerRepository
				.find(targetId).get().getBalance());
		// clear up the effect towards system
		clearUpCollision(initiatorId, targetId, dealId);
	}

	private void clearUpCollision(long initiatorId, long targetId, long dealId) {
		this.dealRepository.detach(dealId);
		this.customerRepository.detach(initiatorId);
		this.customerRepository.detach(targetId);
	}

	@Test
	public void testNotCascadeDelete() {
		long initiatorId = 1001, targetId = 1002, dealId = 1003;
		// prepare for maybe collision
		this.clearUpCollision(initiatorId, targetId, dealId);
		// construct the parameters
		Customer initiator = new Customer(initiatorId, "initial-1001", 1000), target = new Customer(
				targetId, "target-1002", 1000);
		this.customerRepository.attach(initiator);
		this.customerRepository.attach(target);
		Deal deal = new Deal(dealId, initiator, target, 200);
		assertTrue(this.dealRepository.attach(deal));
		// delete the many counter-part
		assertTrue(this.dealRepository.detach(dealId));
		assertTrue(this.customerRepository.find(initiatorId).isPresent());
		assertTrue(this.customerRepository.find(targetId).isPresent());
		// assertTrue(this.customerRepository.detach(initiatorId));
		// clear up the effect towards system
	}
}

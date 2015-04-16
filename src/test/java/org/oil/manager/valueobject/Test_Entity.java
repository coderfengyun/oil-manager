package org.oil.manager.valueobject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.oil.manager.entity.CompositeId;
import org.oil.manager.entity.TestEntity;
import org.oil.manager.repository.NoSetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Test_Entity {
	@Autowired
	private NoSetterRepository repo;

	@Test
	public void testInit() {
		assertNull(this.repo.find(CompositeId.buildId("133.13.13.12", "6565")));
	}

	@Test
	public void testInsertWithTheSameCompositeId() {
		CompositeId compositeId = CompositeId.buildId("123.213.123.12", "4545");
		assertTrue(this.repo.attach(TestEntity.build(compositeId, "name", 1)));
		assertFalse(this.repo.attach(TestEntity.build(compositeId, "asdf", 12)));
		this.repo.detach(this.repo.find(compositeId));
	}

	@Test
	public void testAutowiredField() {
		CompositeId compositeId = CompositeId
				.buildId("133.133.123.12", "21300");
		this.repo.detach(compositeId);
		assertTrue(this.repo.attach(TestEntity.build(compositeId, "name", 1)));
		TestEntity result = this.repo.find(compositeId);
		assertNull(result.getRepo());
	}

	@Test
	public void testAttachTwoEntityWithTheSameName() {
		String name = "chen";
		CompositeId firstId = CompositeId.buildId("133.133.133.9", "2345"), secondId = CompositeId
				.buildId("127.0.9.1", "12");
		this.repo.detach(firstId);
		this.repo.detach(secondId);
		assertTrue(this.repo.attach(TestEntity.build(firstId, name, 123)));
		assertFalse(this.repo.attach(TestEntity.build(secondId, name, 134)));
		this.repo.detach(firstId);
		this.repo.detach(secondId);
	}
}

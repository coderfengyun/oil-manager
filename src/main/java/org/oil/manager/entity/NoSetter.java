package org.oil.manager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "no_setter")
public class NoSetter {
	private int val;
	private String name;
	@EmbeddedId
	private CompositeId compositeId;

	@Autowired
	@Transient
	private WellBaseDataRepository repo;

	public CompositeId getCompositeId() {
		return compositeId;
	}

	private void setCompositeId(CompositeId compositeId) {
		this.compositeId = compositeId;
	}

	public int getVal() {
		return val;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Transient
	public WellBaseDataRepository getRepo() {
		return this.repo;
	}

	public static NoSetter build(CompositeId compositeId, String name, int val) {
		NoSetter result = new NoSetter();
		result.setCompositeId(compositeId);
		result.setName(name);
		result.val = val;
		return result;
	}
}

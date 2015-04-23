package org.oil.manager.entity.compositeid;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.oil.manager.entity.CompositeId;
import org.oil.manager.repository.WellBaseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "entity_with_composite_id")
public class EntityWithCompositeId {
	private int val;
	@Column(unique = true)
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

	public static EntityWithCompositeId build(CompositeId compositeId,
			String name, int val) {
		EntityWithCompositeId result = new EntityWithCompositeId();
		result.setCompositeId(compositeId);
		result.setName(name);
		result.val = val;
		return result;
	}

	public Object getRepo() {
		return this.repo;
	}
}

package org.oil.manager.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deal", uniqueConstraints = {})
public class Deal {
	public static final String COLUMN_INITIATOR = "initiator";
	public static final String COLUMN_INITIATOR_ID = "initiatorId";
	@Id
	private long id;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = COLUMN_INITIATOR_ID, nullable = true, updatable = true)
	private Customer initiator;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(nullable = true, updatable = true)
	private Customer target;
	@Column(nullable = false)
	private double amount;

	public Deal() {
	}

	public Deal(long id, Customer initiator, Customer target, double amount) {
		this.id = id;
		this.initiator = initiator;
		this.target = target;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public Customer getInitiator() {
		return initiator;
	}

	public void makeItHappen() throws NoEnoughBalaceException {
		this.initiator.transferTo(this.target, this.amount);
	}
}

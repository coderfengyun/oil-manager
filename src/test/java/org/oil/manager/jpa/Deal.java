package org.oil.manager.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class Deal {
	@Id
	private long id;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(nullable = true)
	private Customer initiator;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(nullable = true)
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

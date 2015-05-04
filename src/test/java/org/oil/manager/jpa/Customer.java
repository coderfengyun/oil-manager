package org.oil.manager.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = { Customer.COLUMN_NAME }) })
public class Customer {
	static final String COLUMN_NAME = "name";
	@Id
	private long id;
	@Column(name = COLUMN_NAME)
	private String name;
	@Column(nullable = false)
	private double balance;

	public Customer() {
	}

	public Customer(long id, String name, double initialBalance) {
		this.id = id;
		this.name = name;
		this.balance = initialBalance;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void transferTo(Customer target, double amount)
			throws NoEnoughBalaceException {
		if (amount <= 0) {
			throw new IllegalArgumentException(
					"amount can't be negative number");
		}
		if (this.balance < amount) {
			throw new NoEnoughBalaceException();
		}
		this.balance -= amount;
		target.balance += amount;
	}

}

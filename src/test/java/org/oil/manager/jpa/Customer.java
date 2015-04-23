package org.oil.manager.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	private long id;
	@Column
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

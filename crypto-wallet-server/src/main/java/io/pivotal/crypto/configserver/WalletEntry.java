package io.pivotal.crypto.configserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WalletEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String currency;
	private double amount;

	public WalletEntry() {

	}

	public WalletEntry(long id, String currency, double amount) {
		this.id = id;
		this.currency = currency;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}

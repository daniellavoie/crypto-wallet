package io.pivotal.crypto.configserver;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wallet {
	@Id
	private String userId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<WalletEntry> entries;

	public Wallet() {

	}

	public Wallet(String userId, List<WalletEntry> entries) {
		this.userId = userId;
		this.entries = entries;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<WalletEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<WalletEntry> entries) {
		this.entries = entries;
	}
}

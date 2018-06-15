package io.pivotal.crypto.configserver;

import java.util.List;

public interface WalletService {
	List<Wallet> findAll();
	
	void save(Wallet wallet);
	
	double calculate(String productId, double amount);
}

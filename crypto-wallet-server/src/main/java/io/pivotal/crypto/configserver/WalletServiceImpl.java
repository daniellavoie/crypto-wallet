package io.pivotal.crypto.configserver;

import java.util.List;

import org.springframework.stereotype.Service;

import io.pivotal.crypto.coinbase.CoinbaseService;

@Service
public class WalletServiceImpl implements WalletService {
	private CoinbaseService coinbaseService;
	private WalletRepository walletRepository;

	public WalletServiceImpl(CoinbaseService coinbaseService, WalletRepository walletRepository) {
		this.coinbaseService = coinbaseService;
		this.walletRepository = walletRepository;
	}

	@Override
	public List<Wallet> findAll() {
		return walletRepository.findAll();
	}

	@Override
	public void save(Wallet wallet) {
		walletRepository.save(wallet);
	}

	@Override
	public double calculate(String productId, double amount) {
		return coinbaseService.getProductBook(productId).getBids().get(0)[0] * amount;
	}

}

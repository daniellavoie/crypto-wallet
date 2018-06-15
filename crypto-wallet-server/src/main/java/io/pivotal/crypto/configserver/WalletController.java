package io.pivotal.crypto.configserver;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	private WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@GetMapping
	public List<Wallet> findAll() {
		return walletService.findAll();
	}

	@PostMapping
	public void save(@RequestBody Wallet wallet) {
		walletService.save(wallet);
	}

	@GetMapping("/price")
	public double calculateProductValue(@RequestParam String currency, @RequestParam double amount) {
		return walletService.calculate(currency + "-USD", amount);
	}
}

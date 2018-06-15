package io.pivotal.crypto.coinbase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinbaseAutoConfiguration {
	@Bean
	public CoinbaseService coinbaseService(CoinbaseProperties coinbaseProperties) {
		return new CoinbaseServiceImpl(coinbaseProperties);
	}
}

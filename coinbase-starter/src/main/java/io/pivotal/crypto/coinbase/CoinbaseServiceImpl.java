package io.pivotal.crypto.coinbase;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinbaseServiceImpl implements CoinbaseService {
	private RestTemplate restTemplate = new RestTemplate();

	private String coinbaseUrl;

	public CoinbaseServiceImpl(CoinbaseProperties coinbaseConfig) {
		this.coinbaseUrl = coinbaseConfig.getUrl();
	}

	@Override
	public ProductBookResponse getProductBook(String productId) {
		return restTemplate.getForObject(coinbaseUrl + "/products/{productId}/book", ProductBookResponse.class,
				productId);
	}

}

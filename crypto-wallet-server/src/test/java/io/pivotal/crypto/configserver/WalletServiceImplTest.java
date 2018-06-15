package io.pivotal.crypto.configserver;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.crypto.coinbase.CoinbaseService;
import io.pivotal.crypto.coinbase.ProductBookResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WalletServiceImplTest {
	@MockBean
	private CoinbaseService coinbaseService;

	@Autowired
	private WalletService walletService;

	@Test
	public void testCalculation() {
		ProductBookResponse expectedResponse = new ProductBookResponse(1, Arrays.asList(new double[] { 10d }),
				Arrays.asList(new double[] { 11d }));

		BDDMockito.when(coinbaseService.getProductBook("BTC-USD")).thenReturn(expectedResponse);

		Assert.assertEquals(100d, walletService.calculate("BTC-USD", 10), 0.001d);
	}
}

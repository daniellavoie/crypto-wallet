package io.pivotal.crypto.configserver;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WalletControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testWebService() {
		restTemplate.postForObject("/wallet", new Wallet("Daniel", Arrays.asList()), Void.class);

		List<Wallet> response = restTemplate
				.exchange("/wallet", HttpMethod.GET, null, new ParameterizedTypeReference<List<Wallet>>() {
				}).getBody();

		Assert.assertEquals(1, response.stream().map(Wallet::getUserId).filter(id -> id.equals("Daniel")).count());
	}
}

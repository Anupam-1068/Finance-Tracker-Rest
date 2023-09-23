package com.mainor.financetracker;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FinanceTrackerApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAllAccounts() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/accounts", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Add more assertions based on your response structure
	}

	@Test
	public void testCreateNewUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<>("{\"username\":\"newuser\", \"password\":\"newpassword\"}", headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/api/user", HttpMethod.POST, request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		// Add more assertions based on your response structure
	}



}

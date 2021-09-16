package com.beta.replyservice;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class RestServiceApplicationTest {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSuccessReplyV2() throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/v2/reply/12-kbzw9ru");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		//Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testInvalidInputReplyV2() throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/v2/reply/13-kbzw9ru");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		//Verify request succeed
		Assertions.assertEquals(true, result.getBody().contains("400"));
	}
}

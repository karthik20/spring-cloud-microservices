package com.karthik.springcloudm4securecli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;

@SpringBootApplication
public class SpringcloudM4SecureCliApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecureCliApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Starting Cron job..");
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:9008/services/oauth/token");

		resourceDetails.setScope(Arrays.asList("toll_read"));
		resourceDetails.setClientId("spring-security");
		resourceDetails.setClientSecret("spring-secret");

		resourceDetails.setUsername("koushik");
		resourceDetails.setPassword("kou");

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		String tokenValue = restTemplate.getAccessToken().toString();
		System.out.println("CLI : Received Token ::"+tokenValue);

		String op = restTemplate.getForObject("http://localhost:9001/services/tollData", String.class);
		System.out.println(op);
	}
}

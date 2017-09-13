package com.karthik.springcloudm4secureauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class SpringcloudM4SecureAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecureAuthApplication.class, args);
	}
}

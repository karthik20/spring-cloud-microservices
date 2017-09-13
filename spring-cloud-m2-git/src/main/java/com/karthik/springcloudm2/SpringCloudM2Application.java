package com.karthik.springcloudm2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudM2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM2Application.class, args);
	}
}

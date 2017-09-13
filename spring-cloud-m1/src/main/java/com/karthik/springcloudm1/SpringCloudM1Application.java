package com.karthik.springcloudm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudM1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM1Application.class, args);
	}
}

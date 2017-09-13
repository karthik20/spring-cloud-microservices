package com.karthik.springcloudm3tasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpringcloudM3TasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM3TasksinkApplication.class, args);
	}
}

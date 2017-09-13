package com.karthik.springcloudm3task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringcloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM3TaskApplication.class, args);
	}

	public class TollProcessingTask implements CommandLineRunner{

		@Bean
		public TollProcessingTask tollProcessingTask(){
			return new TollProcessingTask();
		}

		@Override
		public void run(String... strings) throws Exception {
			//Parameters station id, license plate, timestamp
			if(null != strings){
				System.out.println("Param length is "+ strings.length);

				String stationId = strings[0];
				String licensePlate = strings[1];
				String timestamp = strings[2];

				System.out.println("Station Id : "+stationId+" License# : "+licensePlate+" TIme Of Arrival : "+timestamp);

			}
		}
	}
}

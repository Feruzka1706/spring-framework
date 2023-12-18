package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Spring17RestConsumingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring17RestConsumingApIsApplication.class, args);
	}

	//configure bean object of RestTemplate because of class doesn't belong to use
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


}

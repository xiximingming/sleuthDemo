package com.example.sleuthDemo;

import brave.sampler.Sampler;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class SleuthDemoApplication {

	@Autowired private RestTemplate restTemplate;

	public static void main(String[] args) {

		SpringApplication.run(SleuthDemoApplication.class, args);
	}



	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}



	private static final Logger LOG = Logger.getLogger(SleuthDemoApplication.class.getName());

	@RequestMapping("/")
	public String home() {
		LOG.log(Level.INFO, "you called home");
		return "Hello World";

	}

	@RequestMapping("/callhome")
	public String callHome(){
		LOG.log(Level.INFO, "calling home");
		return restTemplate.getForObject("http://localhost:8080", String.class);
	}



}

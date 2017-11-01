package com.spectrum.fusionbackend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spectrum.fusionbackend.services.configurations.PersonConfiguration;

@RestController
@RibbonClient(name = "persons-service", configuration = PersonConfiguration.class)
public class PersonsClientController {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/services/persons")
	public List<String> getPersons() {
		@SuppressWarnings("unchecked")
		List<String> persons = this.restTemplate.getForObject("http://persons-service/persons", ArrayList.class);
		return persons;
	}

}
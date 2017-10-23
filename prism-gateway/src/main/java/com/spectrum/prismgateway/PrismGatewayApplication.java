package com.spectrum.prismgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.spectrum.prismgateway.filters.SimpleFilter;

@EnableZuulProxy
@SpringBootApplication
public class PrismGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrismGatewayApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}
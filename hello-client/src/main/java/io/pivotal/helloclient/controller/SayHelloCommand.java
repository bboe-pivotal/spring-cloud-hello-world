package io.pivotal.helloclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class SayHelloCommand {
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "sayHelloFallback")
	public String sayHello(String toWho) {
    	return restTemplate.getForObject("http://hello-world-server/hello?name={name}", String.class, toWho);
	}

	public String sayHelloFallback(String toWho) {
		return String.format("Error! Can't retrieve hello world message for %s", toWho);
	}
}

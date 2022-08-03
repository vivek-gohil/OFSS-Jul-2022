package com.ofss.main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//http:localhost:8080/helloworldapi/greet
@CrossOrigin("*")
@RestController
@RequestMapping("helloworldapi")
public class HelloWorldController {

	//http:localhost:8080/helloworldapi/greet
	@RequestMapping(value="greet" , method = RequestMethod.GET)
	public String printGreetMessage() {
		return "Hello World From REST API";
	}
	
	//http:localhost:8080/helloworldapi/best
	@RequestMapping(value="best" , method = RequestMethod.POST)
	public String printAnotherGreetMessage() {
		return "REST API is BEST";
	}
}

package com.ofss.main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("myfristapi")
public class MyFirstRESTAPI {

	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String printGetMessage() {
		return "This is message for GET request";
	}

	@RequestMapping(value = "message", method = RequestMethod.POST)
	public String printPostMessage() {
		return "This is message for POST request";
	}

	@RequestMapping(value = "message", method = RequestMethod.PUT)
	public String printPutMessage() {
		return "This is message for PUT request";
	}

	@RequestMapping(value = "message", method = RequestMethod.DELETE)
	public String printDeleteMessage() {
		return "This is message for Delete request";
	}

}

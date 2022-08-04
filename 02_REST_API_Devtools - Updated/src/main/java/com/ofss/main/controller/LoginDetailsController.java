package com.ofss.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.pojo.LoginDetails;
import com.ofss.main.repository.LoginDetailsRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("loginapi")
public class LoginDetailsController {

	private LoginDetailsRepository loginDetailsRepository = new LoginDetailsRepository();

	@RequestMapping(value = "addnew", method = RequestMethod.POST)
	public boolean addNewLogin(@RequestBody LoginDetails loginDetails) {
		return loginDetailsRepository.addNewLoginDetails(loginDetails);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public boolean login(@RequestBody LoginDetails loginDetails) {
		return loginDetailsRepository.validateUser(loginDetails);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<LoginDetails> getAll() {
		return loginDetailsRepository.getAllLoginDetails();
	}

}

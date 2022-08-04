package com.ofss.main.repository;

import java.util.ArrayList;
import java.util.List;

import com.ofss.main.pojo.LoginDetails;

public class LoginDetailsRepository {
	private List<LoginDetails> allLoginDetails = new ArrayList<LoginDetails>();

	public LoginDetailsRepository() {
		LoginDetails loginDetails1 = new LoginDetails("101", "password", "user");
		LoginDetails loginDetails2 = new LoginDetails("102", "password", "user");
		LoginDetails loginDetails3 = new LoginDetails("103", "password", "user");

		allLoginDetails.add(loginDetails1);
		allLoginDetails.add(loginDetails2);
		allLoginDetails.add(loginDetails3);
	}

	public boolean addNewLoginDetails(LoginDetails loginDetails) {
		boolean result = allLoginDetails.add(loginDetails);
		return result;
	}

	public boolean validateUser(LoginDetails loginDetails) {
		for (LoginDetails l : allLoginDetails) {
			if (l.getLoginId().equals(loginDetails.getLoginId())
					&& l.getPassword().equals(loginDetails.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public List<LoginDetails> getAllLoginDetails() {
		return allLoginDetails;
	}
}

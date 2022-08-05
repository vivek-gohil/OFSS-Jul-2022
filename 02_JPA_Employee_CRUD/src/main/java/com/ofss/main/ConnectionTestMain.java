package com.ofss.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionTestMain {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Eclipselink_JPA");
		
		EntityManager entityManager = 
				entityManagerFactory.createEntityManager();
		
		System.out.println("Connection Success!!");
	}
}

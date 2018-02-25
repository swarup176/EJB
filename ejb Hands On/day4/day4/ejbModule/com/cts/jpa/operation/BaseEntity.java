package com.cts.jpa.operation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseEntity {
	public static EntityManager entityManager;
	
	/*@PersistenceUnit
	static EntityManagerFactory entityManagerFactory;*/

	static {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("TestJPA");
		entityManager = entityManagerFactory.createEntityManager();
	}
}

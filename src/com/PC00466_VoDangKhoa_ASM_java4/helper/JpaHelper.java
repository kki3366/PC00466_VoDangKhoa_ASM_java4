package com.PC00466_VoDangKhoa_ASM_java4.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelper {
	private static EntityManagerFactory entityManagerFactory;
	
	static final String namedPersistenceUnit = "DB";
	
	static public EntityManager getEntityManager() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory(namedPersistenceUnit);
			System.out.println("Đã connect");
		}
		return entityManagerFactory.createEntityManager();
	}
	
	static public void shutDown() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
		entityManagerFactory = null;
	}
}

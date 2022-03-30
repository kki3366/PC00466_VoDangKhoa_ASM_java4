package com.PC00466_VoDangKhoa_ASM_java4.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class test {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
	EntityManager em = emf.createEntityManager();
try {
		
		em.getTransaction().begin();
		Users user = new Users();
		user.setId("test1");
		user.setPassword("123");
		user.setFullname("zzzz");
		user.setEmail("zzzz");
		user.setRole(true);
		em.persist(user);
		
		em.getTransaction().commit();
		System.out.println("Thành công");
	} catch (Exception e) {
		em.getTransaction().rollback();
		System.out.println("Không thành công");
		e.printStackTrace();
	}
}
}

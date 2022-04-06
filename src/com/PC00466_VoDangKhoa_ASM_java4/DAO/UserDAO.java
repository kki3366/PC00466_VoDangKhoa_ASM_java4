package com.PC00466_VoDangKhoa_ASM_java4.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;
import com.PC00466_VoDangKhoa_ASM_java4.helper.JpaHelper;


public class UserDAO extends DAO<Users, String> {

	
	private EntityManager entityManager = JpaHelper.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public Users create(Users entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public Users update(Users entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public Users remove(String id) {
		Users users = this.findById(id);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(users);
			entityManager.getTransaction().commit();
			return users;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Users> findAll() {
		String jpql = "select n from Users n";
		TypedQuery<Users> query = entityManager.createQuery(jpql,Users.class);
		List<Users> list = query.getResultList();
		return list;
	}
	
	public Users findById(String id) {
		Users users = entityManager.find(Users.class, id);
		return users;
	}

	public Users findByEmail(String email) {
		String jpql = "select n from Users n where n.email =:email";
		TypedQuery<Users> query = entityManager.createQuery(jpql,Users.class);
		query.setParameter("email", email);
		Users user = query.getSingleResult();
		return user;
		
	}
}

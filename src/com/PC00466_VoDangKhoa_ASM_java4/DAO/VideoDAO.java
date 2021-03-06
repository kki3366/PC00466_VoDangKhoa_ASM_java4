package com.PC00466_VoDangKhoa_ASM_java4.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.PC00466_VoDangKhoa_ASM_java4.entity.Videos;
import com.PC00466_VoDangKhoa_ASM_java4.helper.JpaHelper;

public class VideoDAO extends DAO<Videos, String>{

	private EntityManager entityManager = JpaHelper.getEntityManager();
	
	@Override
	public Videos create(Videos entity) {
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
	public Videos update(Videos entity) {
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
	public Videos remove(String id) {
		Videos videos = this.findById(id);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(videos);
			entityManager.getTransaction().commit();
			return videos;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Videos> findAll() {
		String jpql = "select n from Videos n";
		TypedQuery<Videos> query = entityManager.createQuery(jpql,Videos.class);
		List<Videos> list = query.getResultList();
		return list;
	}

	public List<Videos> findAllActive() {
		String jpql = "select n from Videos n where n.active = 1";
		TypedQuery<Videos> query = entityManager.createQuery(jpql,Videos.class);
		List<Videos> list = query.getResultList();
		return list;
	}
	
	public Videos findById(String id) {
		Videos videos = entityManager.find(Videos.class, id);
		return videos;
	}
	
	
	public List<String> findTitle(){
		String jpql = "select n.title from Videos n";
		TypedQuery<String> query = entityManager.createQuery(jpql,String.class);
		List<String> list = query.getResultList();
		return list;
	}
	
	public List<String> FavoritesUser(String id){
		String jpql = "select n.user from Favorite n where n.video.id =:id";
		TypedQuery<String> query = entityManager.createQuery(jpql,String.class);
		query.setParameter("id", id);
		List<String> list = query.getResultList();
		return list;
	}
	
	
	
	

}

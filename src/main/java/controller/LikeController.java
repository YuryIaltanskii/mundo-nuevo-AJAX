package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Like;
import model.Post;
import model.User;

public class LikeController {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(User user, Post post, String like){
		post = entityManager.merge(post);
		Like l = new Like();
		l.setPost(post);
		l.setUser(user);
		l.setLike(like);
		entityManager.persist(l);
	}
	
	public List<Like> byPost(Post post){
		String jpql = "Select l From Like l where l.post = :post";
		TypedQuery<Like> q = entityManager.createQuery(jpql, Like.class);
		q.setParameter("post", post);
		return q.getResultList();
	}
	
	public List<Like> from(User user, int from,int max){
		TypedQuery<Like> q = entityManager.createQuery("Select l from Like l where l.user = :user",Like.class);
		q.setParameter("user",user);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}
}

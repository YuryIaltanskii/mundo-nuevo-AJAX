package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Image;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addPost(User user, String content, Image img){
		Post p = new Post();
		p.setDate(new Date());
		p.setContent(content);
		p.setUser(user);
		p.setImage(img);
		entityManager.persist(p);
	}
	
	public List<Post> all(int from,int max){
		TypedQuery<Post> q = entityManager.createQuery("Select p from Post p",Post.class);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}
	
	
	public List<Post> from(User user, int from,int max){
		TypedQuery<Post> q = entityManager.createQuery("Select p from Post p where p.user = :user",Post.class);
		q.setParameter("user",user);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}

	public Post byId(int id) {
		return entityManager.find(Post.class, id);
	}
	
	
}

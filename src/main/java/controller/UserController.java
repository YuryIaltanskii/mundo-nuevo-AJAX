package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import exception.AuthenticationFailure;
import model.User;

@Stateless
public class UserController {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public User byId(int id) {
		return entityManager.find(User.class, id);
	}
	
	public User findByName(String name) {
		String jpql = "Select u from User u where u.name = :username";
		TypedQuery<User> q = entityManager.createQuery(jpql, User.class);
		q.setParameter("username", name);
		return q.getSingleResult();
	}
	
	public User authenticate(String username,String password) throws AuthenticationFailure {
		try{
			String jpql = "Select u from User u where u.name = :username and u.password = :password";
			TypedQuery<User> q = entityManager.createQuery(jpql, User.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			return q.getSingleResult();
		} catch (PersistenceException e){
			throw new AuthenticationFailure(e);
		}
	}

}

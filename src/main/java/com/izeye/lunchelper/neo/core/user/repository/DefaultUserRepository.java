package com.izeye.lunchelper.neo.core.user.repository;

import com.izeye.lunchelper.neo.core.user.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by izeye on 15. 10. 3..
 */
@Repository
public class DefaultUserRepository implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User save(User user) {
		if (user.getId() == null) {
			em.persist(user);
		}
		else {
			em.merge(user);
		}
		return user;
	}

	@Override
	public User findOne(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User findByUsername(String username) {
		List<User> users = em.createQuery(
				"select u from User u where u.username = :username", User.class)
				.setParameter("username", username)
				.getResultList();
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	
}

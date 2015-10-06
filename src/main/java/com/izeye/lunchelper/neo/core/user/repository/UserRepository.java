package com.izeye.lunchelper.neo.core.user.repository;

import com.izeye.lunchelper.neo.core.user.domain.User;

import java.util.List;

/**
 * Created by izeye on 15. 10. 3..
 */
public interface UserRepository {

	User save(User user);

	User findOne(Long id);
	
	List<User> findAll();
	
	User findByUsername(String username);
	
}

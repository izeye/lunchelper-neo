package com.izeye.lunchelper.neo.core.user.service;

import com.izeye.lunchelper.neo.core.user.domain.User;

import java.util.List;

/**
 * Created by izeye on 15. 10. 3..
 */
public interface UserService {
	
	User signUp(User user);
	
	User signIn(String username, String password);
	
	List<User> findAll();
	
}

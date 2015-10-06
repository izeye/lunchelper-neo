package com.izeye.lunchelper.neo.core.user.service;

import com.izeye.lunchelper.neo.core.user.domain.User;
import com.izeye.lunchelper.neo.core.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by izeye on 15. 10. 3..
 */
@Service
@Transactional
public class DefaultUserService implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User signUp(User user) {
		String username = user.getUsername();
		if (userRepository.findByUsername(username) != null) {
			throw new IllegalArgumentException(
					"The username has been already occupied: " + username);
		}
		return userRepository.save(user);
	}

	@Override
	public User signIn(String username, String password) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}

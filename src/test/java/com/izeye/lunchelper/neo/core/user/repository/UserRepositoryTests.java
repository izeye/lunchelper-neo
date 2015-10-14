package com.izeye.lunchelper.neo.core.user.repository;

import com.izeye.lunchelper.neo.Application;
import com.izeye.lunchelper.neo.core.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class UserRepositoryTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		// Given
		User user = new User("izeye", "1234");

		// When
		userRepository.save(user);
		
		// Then
		assertThat(userRepository.findAll(), contains(user));
		assertThat(userRepository.findOne(user.getId()), is(sameInstance(user)));
		assertThat(userRepository.findByUsername(user.getUsername()), is(sameInstance(user)));
	}
	
}

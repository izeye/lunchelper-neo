package com.izeye.lunchelper.neo.core.user.service;

import com.izeye.lunchelper.neo.Application;
import com.izeye.lunchelper.neo.core.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by izeye on 15. 10. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceTests {
	
	@Autowired
	UserService userService;
	
	@Test
	public void test() {
		// Given
		User user = new User();
		user.setUsername("izeye");
		user.setPassword("1234");

		// When
		User signedUpUser = userService.signUp(user);

		// Then
		assertThat(signedUpUser.getId(), is(not(nullValue())));
		assertThat(userService.findAll(), contains(signedUpUser));
	}
	
}

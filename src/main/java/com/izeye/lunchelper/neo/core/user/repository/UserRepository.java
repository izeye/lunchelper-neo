package com.izeye.lunchelper.neo.core.user.repository;

import com.izeye.lunchelper.neo.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by izeye on 15. 10. 3..
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}

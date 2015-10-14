package com.izeye.lunchelper.neo.support.test;

import com.izeye.lunchelper.neo.core.restaurant.domain.Menu;
import com.izeye.lunchelper.neo.core.restaurant.domain.MenuRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantRating;
import com.izeye.lunchelper.neo.core.restaurant.repository.MenuRatingRepository;
import com.izeye.lunchelper.neo.core.restaurant.repository.MenuRepository;
import com.izeye.lunchelper.neo.core.restaurant.repository.RestaurantRatingRepository;
import com.izeye.lunchelper.neo.core.restaurant.repository.RestaurantRepository;
import com.izeye.lunchelper.neo.core.user.domain.User;
import com.izeye.lunchelper.neo.core.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import java.util.List;

import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createMenuRating;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createMenus;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createRestaurant;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createRestaurantRating;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createUser;

/**
 * Created by izeye on 15. 10. 13..
 */
@Configuration
public class TestConfig {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	RestaurantRatingRepository restaurantRatingRepository;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	MenuRatingRepository menuRatingRepository;
	
	@PostConstruct
	public void initialize() {
		User user = createUser();
		userRepository.save(user);

		Restaurant restaurant = createRestaurant();
		restaurantRepository.save(restaurant);

		RestaurantRating restaurantRating = createRestaurantRating(user, restaurant);
		restaurantRatingRepository.save(restaurantRating);

		List<Menu> menus = createMenus(restaurant);
		menuRepository.save(menus);

		for (Menu menu : menus) {
			MenuRating menuRating = createMenuRating(user, menu);
			menuRatingRepository.save(menuRating);
		}
	}
	
}

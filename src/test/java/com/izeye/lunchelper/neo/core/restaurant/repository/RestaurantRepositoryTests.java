package com.izeye.lunchelper.neo.core.restaurant.repository;

import com.izeye.lunchelper.neo.Application;
import com.izeye.lunchelper.neo.core.restaurant.domain.Menu;
import com.izeye.lunchelper.neo.core.restaurant.domain.MenuRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantRating;
import com.izeye.lunchelper.neo.core.user.domain.User;
import com.izeye.lunchelper.neo.core.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createMenu;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createMenuRating;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createRestaurant;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createRestaurantRating;
import static com.izeye.lunchelper.neo.support.test.TestDomainFactory.createUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.Is.is;

/**
 * Created by izeye on 15. 10. 6..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class RestaurantRepositoryTests {
	
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
	
	@Test
	public void test() {
		User user = createUser();
		userRepository.save(user);
		
		Restaurant restaurant = createRestaurant();
		restaurantRepository.save(restaurant);

		assertThat(restaurantRepository.findAll(), contains(restaurant));
		assertThat(restaurantRepository.findOne(restaurant.getId()),
				is(sameInstance(restaurant)));

		RestaurantRating restaurantRating = createRestaurantRating(user, restaurant);
		restaurantRatingRepository.save(restaurantRating);

		assertThat(restaurantRatingRepository.findAll(), contains(restaurantRating));
		assertThat(restaurantRatingRepository.findOne(restaurantRating.getId()),
				is(sameInstance(restaurantRating)));

		Menu menu = createMenu(restaurant);
		menuRepository.save(menu);

		assertThat(menuRepository.findAll(), contains(menu));
		assertThat(menuRepository.findOne(menu.getId()), is(sameInstance(menu)));

		MenuRating menuRating = createMenuRating(user, menu);
		menuRatingRepository.save(menuRating);

		assertThat(menuRatingRepository.findAll(), contains(menuRating));
		assertThat(menuRatingRepository.findOne(menuRating.getId()),
				is(sameInstance(menuRating)));
	}

}

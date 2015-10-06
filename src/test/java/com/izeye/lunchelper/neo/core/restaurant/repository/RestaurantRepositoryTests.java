package com.izeye.lunchelper.neo.core.restaurant.repository;

import com.izeye.lunchelper.neo.Application;
import com.izeye.lunchelper.neo.core.restaurant.domain.Menu;
import com.izeye.lunchelper.neo.core.restaurant.domain.MenuRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.RatingScore;
import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantType;
import com.izeye.lunchelper.neo.core.user.domain.User;
import com.izeye.lunchelper.neo.core.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

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

	private User createUser() {
		User user = new User();
		user.setUsername("izeye");
		user.setPassword("1234");
		return user;
	}

	private Restaurant createRestaurant() {
		Restaurant restaurant = new Restaurant();
		restaurant.setType(RestaurantType.KOREAN);
		restaurant.setName("콩두 분당미금점");
		restaurant.setAddress("경기도 성남시 분당구 금곡동 158 미도프라자 1층 116호");
		return restaurant;
	}

	private RestaurantRating createRestaurantRating(User user, Restaurant restaurant) {
		RestaurantRating rating = new RestaurantRating();
		rating.setUser(user);
		rating.setScore(RatingScore.VERY_GOOD);
		rating.setComment("Good!");
		restaurant.addRating(rating);
		return rating;
	}

	private Menu createMenu(Restaurant restaurant) {
		Menu menu = new Menu();
		menu.setName("청국장비빔밥");
		menu.setPrice(7000);
		restaurant.addMenu(menu);
		return menu;
	}

	private MenuRating createMenuRating(User user, Menu menu) {
		MenuRating menuRating = new MenuRating();
		menuRating.setUser(user);
		menuRating.setScore(RatingScore.VERY_GOOD);
		menuRating.setComment("Good!");
		menu.addRating(menuRating);
		return menuRating;
	}

}

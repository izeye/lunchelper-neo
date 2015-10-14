package com.izeye.lunchelper.neo.support.test;

import com.izeye.lunchelper.neo.core.restaurant.domain.Menu;
import com.izeye.lunchelper.neo.core.restaurant.domain.MenuRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.RatingScore;
import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantRating;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantType;
import com.izeye.lunchelper.neo.core.user.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by izeye on 15. 10. 13..
 */
public abstract class TestDomainFactory {

	public static User createUser() {
		return new User("izeye", "1234");
	}

	public static Restaurant createRestaurant() {
		return new Restaurant(
				RestaurantType.KOREAN,
				"콩두 분당미금점",
				"경기도 성남시 분당구 금곡동 158 미도프라자 1층 116호");
	}

	public static RestaurantRating createRestaurantRating(User user, Restaurant restaurant) {
		return new RestaurantRating(user, RatingScore.VERY_GOOD, "Good!", restaurant);
	}
	
	public static List<Menu> createMenus(Restaurant restaurant) {
		List<Menu> menus = new ArrayList<>();
		menus.add(new Menu(restaurant, "청국장비빔밥", 7000));
		menus.add(new Menu(restaurant, "테스트", 5000));
		return menus;
	}
	
	public static Menu createMenu(Restaurant restaurant) {
		return new Menu(restaurant, "청국장비빔밥", 7000);
	}

	public static MenuRating createMenuRating(User user, Menu menu) {
		return new MenuRating(user, RatingScore.VERY_GOOD, "Good!", menu);
	}
	
}

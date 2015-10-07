package com.izeye.lunchelper.neo.core.restaurant.service;

import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;

import java.util.List;

/**
 * Created by izeye on 15. 10. 6..
 */
public interface RestaurantService {
	
	void add(Restaurant restaurant);
	
	List<Restaurant> list();
	
}

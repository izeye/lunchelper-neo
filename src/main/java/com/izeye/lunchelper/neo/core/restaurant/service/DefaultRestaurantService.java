package com.izeye.lunchelper.neo.core.restaurant.service;

import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by izeye on 15. 10. 6..
 */
@Service
@Transactional
public class DefaultRestaurantService implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public void add(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> list() {
		return restaurantRepository.findAll();
	}
	
}

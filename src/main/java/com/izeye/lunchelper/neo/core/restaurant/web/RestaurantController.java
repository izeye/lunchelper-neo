package com.izeye.lunchelper.neo.core.restaurant.web;

import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantType;
import com.izeye.lunchelper.neo.core.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by izeye on 15. 10. 6..
 */
@Controller
@RequestMapping(path = "/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("types", RestaurantType.values());
		return "restaurants/add";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String add(Restaurant restaurant) {
		restaurantService.add(restaurant);
		System.out.println(restaurant);
		return "redirect:list";
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		List<Restaurant> restaurants = restaurantService.list();
		System.out.println(restaurants);
		model.addAttribute("restaurants", restaurants);
		return "restaurants/list";
	}
	
}

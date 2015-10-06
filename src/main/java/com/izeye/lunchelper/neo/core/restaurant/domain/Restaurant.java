package com.izeye.lunchelper.neo.core.restaurant.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "ratings")
public class Restaurant extends TimestampManaged {
	
	private RestaurantType type;
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "restaurant")
	private List<Menu> menus = new ArrayList<>();

	@OneToMany(mappedBy = "restaurant")
	private List<RestaurantRating> ratings = new ArrayList<>();
	
	public void addMenu(Menu menu) {
		this.menus.add(menu);
		menu.setRestaurant(this);
	}
	
	public void addRating(RestaurantRating rating) {
		this.ratings.add(rating);
		rating.setRestaurant(this);
	}
	
}

package com.izeye.lunchelper.neo.core.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.izeye.lunchelper.neo.core.user.domain.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
@ToString(exclude = "restaurant")
public class RestaurantRating extends AbstractRating {
	
	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	@JsonIgnore
	private Restaurant restaurant;
	
	public RestaurantRating(
			User user, RatingScore score, String comment, Restaurant restaurant) {
		super(user, score, comment);
		
		this.restaurant = restaurant;
		this.restaurant.addRating(this);
	}
	
	protected RestaurantRating() {
	}
	
}

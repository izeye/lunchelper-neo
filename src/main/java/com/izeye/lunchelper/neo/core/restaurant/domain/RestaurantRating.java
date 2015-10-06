package com.izeye.lunchelper.neo.core.restaurant.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
public class RestaurantRating extends AbstractRating {
	
	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;
	
}

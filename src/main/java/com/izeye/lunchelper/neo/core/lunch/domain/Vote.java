package com.izeye.lunchelper.neo.core.lunch.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import com.izeye.lunchelper.neo.core.restaurant.domain.Restaurant;
import com.izeye.lunchelper.neo.core.user.domain.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
public class Vote extends TimestampManaged {

	@ManyToOne
	@JoinColumn(name = "LUNCH_ID")
	private Lunch lunch;

	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
}

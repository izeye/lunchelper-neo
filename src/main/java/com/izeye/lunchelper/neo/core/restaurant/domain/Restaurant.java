package com.izeye.lunchelper.neo.core.restaurant.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
public class Restaurant extends TimestampManaged {
	
	private RestaurantType type;
	private String name;
	private String address;

	@OneToMany(mappedBy = "restaurant")
	private List<RestaurantRating> ratings;
	
}

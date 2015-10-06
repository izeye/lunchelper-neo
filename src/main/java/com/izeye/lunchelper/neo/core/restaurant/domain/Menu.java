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
public class Menu extends TimestampManaged {
	
	private String name;
	private int price;
	
	@OneToMany(mappedBy = "menu")
	private List<MenuRating> ratings;
	
}

package com.izeye.lunchelper.neo.core.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
@ToString(exclude = "restaurant")
public class Menu extends TimestampManaged {
	
	private String name;
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	@JsonIgnore
	private Restaurant restaurant;
	
	@OneToMany(mappedBy = "menu")
	private List<MenuRating> ratings = new ArrayList<>();
	
	public Menu(Restaurant restaurant, String name, int price) {
		this.restaurant = restaurant;
		this.name = name;
		this.price = price;
		
		this.restaurant.addMenu(this);
	}
	
	protected Menu() {
	}
	
	public void addRating(MenuRating rating) {
		this.ratings.add(rating);
		rating.setMenu(this);
	}
	
}

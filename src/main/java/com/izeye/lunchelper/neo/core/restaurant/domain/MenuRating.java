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
@ToString(exclude = "menu")
public class MenuRating extends AbstractRating {
	
	@ManyToOne
	@JoinColumn(name = "MENU_ID")
	@JsonIgnore
	private Menu menu;
	
	public MenuRating(User user, RatingScore score, String comment, Menu menu) {
		super(user, score, comment);
		
		this.menu = menu;
		this.menu.addRating(this);
	}
	
	protected MenuRating() {
	}
	
}

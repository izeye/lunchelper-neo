package com.izeye.lunchelper.neo.core.restaurant.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import com.izeye.lunchelper.neo.core.user.domain.User;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by izeye on 15. 10. 2..
 */
@MappedSuperclass
@Data
public class AbstractRating extends TimestampManaged {
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	private int score;
	private String comment;
	
}
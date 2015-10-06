package com.izeye.lunchelper.neo.core.user.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import com.izeye.lunchelper.neo.core.lunch.domain.Vote;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "votes")
public class User extends TimestampManaged {
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Vote> votes;
	
}

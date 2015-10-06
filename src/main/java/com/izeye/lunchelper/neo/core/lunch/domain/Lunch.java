package com.izeye.lunchelper.neo.core.lunch.domain;

import com.izeye.lunchelper.neo.core.domain.TimestampManaged;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by izeye on 15. 10. 2..
 */
@Entity
@Data
public class Lunch extends TimestampManaged {
	
	private LocalDate lunchDate;
	
	@OneToMany(mappedBy = "lunch")
	private Set<Vote> votes;
	
}

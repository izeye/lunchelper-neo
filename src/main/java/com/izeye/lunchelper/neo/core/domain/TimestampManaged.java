package com.izeye.lunchelper.neo.core.domain;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Created by izeye on 15. 10. 2..
 */
@MappedSuperclass
@Data
public abstract class TimestampManaged {
	
	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	
	private String createdBy;
	private String modifiedBy;

	@PrePersist
	private void onCreate() {
		setCreatedTime(LocalDateTime.now());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			setCreatedBy(authentication.getName());
		}
	}

	@PreUpdate
	private void onUpdate() {
		setModifiedTime(LocalDateTime.now());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			setModifiedBy(authentication.getName());
		}
	}
	
}

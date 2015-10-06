package com.izeye.lunchelper.neo.core.domain;

import lombok.Data;

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

	@PrePersist
	private void onCreate() {
		setCreatedTime(LocalDateTime.now());
	}

	@PreUpdate
	private void onUpdate() {
		setModifiedTime(LocalDateTime.now());
	}
	
}

package com.izeye.lunchelper.neo.core.restaurant.repository;

import com.izeye.lunchelper.neo.core.restaurant.domain.MenuRating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 15. 10. 6..
 */
public interface MenuRatingRepository extends JpaRepository<MenuRating, Long> {
}

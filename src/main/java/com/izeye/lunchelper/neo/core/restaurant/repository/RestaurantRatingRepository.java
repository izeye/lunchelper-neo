package com.izeye.lunchelper.neo.core.restaurant.repository;

import com.izeye.lunchelper.neo.core.restaurant.domain.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 15. 10. 6..
 */
public interface RestaurantRatingRepository extends JpaRepository<RestaurantRating, Long> {
}

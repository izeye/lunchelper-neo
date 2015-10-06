package com.izeye.lunchelper.neo.core.restaurant.domain;

/**
 * Created by izeye on 15. 10. 6..
 */
public enum RatingScore {
	
	VERY_BAD(1),
	BAD(2),
	SO_SO(3),
	GOOD(4),
	VERY_GOOD(5);
	
	private final int score;
	
	private RatingScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
}

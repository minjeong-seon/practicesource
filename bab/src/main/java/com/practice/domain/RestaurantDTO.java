package com.practice.domain;
//음식점 정보 담을 객체

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class RestaurantDTO {
	private int restaurantId;
	private String title;
	private String address;
	private int wishlistCount;
	private int reviewCount;
	private int reviewId;
}

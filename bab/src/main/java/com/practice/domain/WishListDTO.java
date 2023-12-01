package com.practice.domain;
//위시리스트 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class WishListDTO {
	private String userId;	//fk
	private int restaurantId;	//fk
	private String title;	//음식점 이름
	private String address;	//음식점 주소
	private int reviewCount;	//리뷰 수 
	private int wishlistCount;	//위시리스트 등록 수
}

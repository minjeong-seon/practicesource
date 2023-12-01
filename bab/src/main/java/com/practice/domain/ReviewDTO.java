package com.practice.domain;
//음식점 리뷰 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ReviewDTO {
	private int reviewId;	//pk
	private int restaurantId;	//fk
	private String userId;	//작성자 아이디
	private String reviewContent;	//내용
	private int grade;	//별등급
	private String reviewDate;	//등록일
	private String reviewUpdatedate;	//수정일
	
	private double starAvg;	//별점 평균
}

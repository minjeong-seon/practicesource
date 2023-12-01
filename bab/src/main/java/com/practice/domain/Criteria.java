package com.practice.domain;
// SQL 쿼리 조건 동적 생성 = 검색 조건 표현 객체
// 엔티티 필요 없으니까 기본 생성자도 필요 없음

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Criteria {
	private int page; //페이지번호
	private int amount;  //한 페이지당 몇 개의 게시물을 보여줄 것인지	
	private String type; //검색조건
	private String keyword; //검색어	
	
	//기본 페이지 번호 1, 페이지 당 게시글 수 10으로 초기화
	public Criteria() {
		this(1,10);
	}
	
	//page랑 amount를 매개변수로 받아 객체 초기화
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}	
	
	//type 필드에 저장된 데이터(문자열)을 공백을 기준으로 배열로 반환
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}

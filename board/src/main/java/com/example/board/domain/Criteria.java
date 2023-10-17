/*
 * 검색관련, 페이지 기준 설정 DTO
 */
package com.example.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Criteria {
	private int page; //페이지 번호
	private int amount;  //한 페이지당 보여줄 게시글 수
	
	private String type; //검색 조건
	private String keyword; //검색어	
	
	public Criteria() {
		// 기본 생성자가 호출되면 페이지(page)를 1로, 항목 수(amount)를 10으로 초기화
		this(1,10);
	}
	
	public Criteria(int page, int amount) {
		super();	// 기본 생성자 호출
		this.page = page;
		this.amount = amount;
	}	
	
	public String[] getTypeArr() {
		// type이 null인 경우 빈 문자열 배열(new String[] {})을 반환
		// null 아니면 type 문자열을 한 문자씩 쪼개서 배열로 만들어 반환
		
		return type == null ? new String[] {} : type.split("");
	}
}

package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;	//전체 데이터 수량(총 게시글 수)
	
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;	
		
		// 현재 페이지 기준 보여지는 끝 페이지 번호(예: 현재 3페이지 --> 보여지는 끝페이지 10페이지)
		// 예) 현재 페이지값 / 10.0 --> ceil(가장 가까운 올림 정수값) --> 10 곱함(=페이지 번호 10개씩 보여줄 거니까)
		this.endPage = (int)(Math.ceil(cri.getPage() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		// 총 페이지 개수 = 총 게시글 수 / 한 페이지 당 보여줄 게시글 수
		int realEnd = (int)(Math.ceil((total / 1.0) / cri.getAmount()));
		
		// 총 페이지 개수 < 마지막 페이지 번호일 때:
		// 예) 총 페이지 개수=7, 마지막 페이지 번호=10
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}

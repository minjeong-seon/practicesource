package com.practice.domain;
//페이지 나누기용 객체

import lombok.Getter;
import lombok.ToString;

@ToString @Getter
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;	//전체 게시글 수
	
	private Criteria cri;	//페이지 번호, 한 페이지 당 보여줄 게시글 수에 대한 정보
	
	public PageDTO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;	
		
		//현재 페이지(=cri.getPage())를 기준으로,
		//마지막 페이지: (현재 페이지/10)과 가까운 정수*10 --> cri.getPage()=13이면 20
		this.endPage = (int)(Math.ceil(cri.getPage() / 10.0)) * 10;
		//시작 페이지: 마지막 페이지 - 9(페이지 번호도 10개씩 보여줄 거니까)
		this.startPage = this.endPage - 9;
				
		//마지막 페이지: (전체 게시글 수/한번에 보여줄 게시글 수*1.0)와 가까운 정수
		int realEnd = (int)(Math.ceil((total / 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		//이전, 다음 페이지는 아래 조건에 따라 활성화
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}

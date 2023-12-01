package com.practice.domain;
// 게시판 객체

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class BoardDTO {
	private int postId;	//PK
	private String postTitle;	//게시글 제목
	private String postContent;	//게시글 내용
	private String userid;	//작성자 아이디
	private Date postRegdate;	//작성일자
	private int replyCnt;	//댓글수
	private int postAuth;	//권한
	
	//첨부파일 정보
	private List<AttachDTO> attachList;	
	
	// 권한 정보 가져오기
	public int getPostAuth() {
        return postAuth;
    }
}

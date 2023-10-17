/*
 * 게시글 DTO
 */
package com.example.board.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class BoardDTO {
	private int postid;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int replyCnt;
	private int likeCnt;
}

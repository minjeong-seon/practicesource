/*
 * 댓글 DTO
 */
package com.example.board.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter @ToString
public class ReplyDTO {
	private int rno;
	private int postid;
	private String reply;
	private String replyer;
	private Date replyDate;	
}

package com.practice.domain;
//게시글에 대한 댓글 객체
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class ReplyDTO {
	private int replyId;
	private int postId;
	private String replyContent;
	private String replyer;
	private Date replyRegdate;	
	private int replyAuth;
}

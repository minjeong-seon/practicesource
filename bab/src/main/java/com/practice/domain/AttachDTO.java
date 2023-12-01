package com.practice.domain;
// 게시판 첨부파일 객체

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class AttachDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private int postId;
}

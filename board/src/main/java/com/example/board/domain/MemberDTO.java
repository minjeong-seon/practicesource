/*
 * 사용자 정보 DTO
 */
package com.example.board.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String profileImage;
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	
	private List<MemberAuthDTO> authorities;
}

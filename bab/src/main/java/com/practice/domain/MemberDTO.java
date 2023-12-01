package com.practice.domain;
//사용자 정보 객체
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @ToString @Setter @Getter
public class MemberDTO {
	private String phone;
	private String userid;
	private String password;
	private String email;
	private String introduce;
	
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	
	private List<MemberAuthDTO> authorities;
}

package com.practice.domain;

// 회원 가입정보(비밀번호) 변경

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class ChangeDTO {
	private String userid;	
	
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;	
	
	public boolean passwordEquals() {
		return newPassword.equals(confirmPassword);
	}
}

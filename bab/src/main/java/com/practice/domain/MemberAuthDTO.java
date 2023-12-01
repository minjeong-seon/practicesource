package com.practice.domain;
//사용자 권한 객체
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberAuthDTO {
	private String userid;
	private String auth;

}

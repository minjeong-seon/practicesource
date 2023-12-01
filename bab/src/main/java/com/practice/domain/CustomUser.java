package com.practice.domain;
//spring security - User 확장 및 커스터마이징 클래스

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	
	//사용자에 대한 추가 정보 -> MemberDTO 객체 참조
	private MemberDTO memberDTO;

	//User 클래스 생성자 호출하여 사용자 정보 초기화
	//GrantedAuthority : 사용자권한 인터페이스
	public CustomUser(String userid, String password, Collection<? extends GrantedAuthority> authorities) {
		super(userid, password, authorities);		
	}

	//MemberDTO 객체 받아서 사용자 정보 초기화
	//getAuthorities() : "ROLE_USER"와 "ROLE_ADMIN" 같은 형식의 문자열 반환
	//SimpleGrantedAuthority : GrantedAuthority 인터페이스 구현클래스
	public CustomUser(MemberDTO memberDTO) {
		super(memberDTO.getUserid(),memberDTO.getPassword(), memberDTO.getAuthorities()
				                                                    .stream()
				                                                    .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				                                                    .collect(Collectors.toList()));
		this.memberDTO = memberDTO;
	}
	
	

}
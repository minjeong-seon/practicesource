/*
 * CustomUser 클래스: 사용자 인증, 권한 부여 관리용 클래스(스프링 시큐리티 User 클래스 확장하여 사용)
 * 
 * lamda식 코드 추가 설명
	// stream() : 스트림 = 컬렉션, 배열 등의 데이터 소스를 데이터의 연속적인 흐름(스트림)을 이용하여 데이터를 순차적으로 처리
	// map() : 스트림 내의 각 요소를 함수로 처리하여 새로운 스트림 생성
	// collection() : 스트림을 수집하여 데이터구조를 원하는 형태로 변환
 */

package com.example.board.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;


@Getter
public class CustomUser extends User {

	private MemberDTO memberDTO;
	
	// username, password, authorities를 인자로 받는 메소드
	// ㄴ> authorities = 사용자가 가진 권한 정보를 나타내는 컬렉션 예: "ROLE_USER", "ROLE_ADMIN"
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}

	
	public CustomUser(MemberDTO memberDTO) {
		// User 클래스의 생성자 호출(순서대로 username, password, authorities)
		// username = memberDTO.getUserid()
		// password = memberDTO.getUserpw()
		// authorities = memberDTO.getAuthorities() 를 SimpleGrantedAuthority 객체로 변환히여 리스트로 생성 collect(Collectors.toList())
		super(memberDTO.getUserid(), memberDTO.getUserpw(), 
				memberDTO.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		

		this.memberDTO = memberDTO;
	}

}
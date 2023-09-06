package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.board.domain.CustomUser;
import com.example.board.domain.MemberDTO;
import com.example.board.mapper.MemberMapper;

//@Service("detail")
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDTO memberDTO = mapper.read(username);
		
		//memberDTO 는 User 클래스 상속 받아서 만든 클래스를 이용해서 리턴
		
		return new CustomUser(memberDTO);
	}

}

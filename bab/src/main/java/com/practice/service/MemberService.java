package com.practice.service;

import com.practice.domain.ChangeDTO;
import com.practice.domain.LoginDTO;
import com.practice.domain.MemberAuthDTO;
import com.practice.domain.MemberDTO;

public interface MemberService {
	//로그인
	public MemberAuthDTO login(LoginDTO loginDTO);
	
	//회원가입
	public boolean register(MemberDTO memberDTO);
	//중복 아이디 체크
	public boolean dupId(String userid);
	//회원탈퇴
	public boolean remove(LoginDTO loginDTO);
	//비밀번호 변경
	public boolean update(ChangeDTO changeDTO);

	public boolean updateMember(MemberDTO memberDTO);
}

package com.practice.mapper;
//사용자 데이터 쿼리 매핑
import org.apache.ibatis.annotations.Mapper;

import com.practice.domain.ChangeDTO;
import com.practice.domain.MemberAuthDTO;
import com.practice.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public String getPass(String userid);

	public MemberAuthDTO login(String userid);

	public int insert(MemberDTO memberDTO);

	public int dupId(String userid);

	public int leave(String userid);

	public int leave_auth(String userid);

	public int update(ChangeDTO changeDTO);

	public int setAuth(MemberAuthDTO memberAuthDTO);

	public MemberDTO read(String userid);

	public int updateMember(MemberDTO memberDTO);
}

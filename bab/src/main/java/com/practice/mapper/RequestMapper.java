package com.practice.mapper;
//음식점 등록 요청 관련 xml 매핑

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.practice.domain.Criteria;
import com.practice.domain.RegisterRstrntDTO;

@Mapper
public interface RequestMapper {
	public List<RegisterRstrntDTO> listRequest(Criteria cri);
	public int sendRequest(RegisterRstrntDTO dto);
	public RegisterRstrntDTO readRequest(int reqId);
	public int deleteRequest(int reqId);
	public int totalReqCnt(Criteria cri);
}

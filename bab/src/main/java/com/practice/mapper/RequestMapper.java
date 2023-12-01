package com.practice.mapper;
//음식점 등록 요청 관련 xml 매핑

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.practice.domain.RegisterRstrntDTO;

@Mapper
public interface RequestMapper {
	public int sendRequest(RegisterRstrntDTO dto);
	public RegisterRstrntDTO readRequest(int reqId);
	public List<RegisterRstrntDTO> listRequest();
	public int deleteRequest(int reqId);
}

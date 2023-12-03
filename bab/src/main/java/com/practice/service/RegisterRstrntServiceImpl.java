package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.domain.Criteria;
import com.practice.domain.RegisterRstrntDTO;
import com.practice.mapper.RequestMapper;

@Service
public class RegisterRstrntServiceImpl implements RegisterRstrntService {
	
	@Autowired
	private RequestMapper mapper;
	
	// 맛집 등록 요청 입력
	@Override
	public boolean sendRequest(RegisterRstrntDTO dto) {
		
		return mapper.sendRequest(dto)==1?true:false;
	}

	// 맛집 등록 요청 상세 보기
	@Override
	public RegisterRstrntDTO readRequest(int reqId) {
		
		return mapper.readRequest(reqId);
	}

	// 맛집 등록 요청 목록
	public List<RegisterRstrntDTO> listRequest(Criteria cri) {
		return mapper.listRequest(cri);
	}

	// 맛집 등록 요청 삭제
	@Override
	public boolean deleteRequest(int reqId) {
		
		return mapper.deleteRequest(reqId)==1?true:false;
	}

	// 맛집 등록 요청 건수
	@Override
	public int totalReqCnt(Criteria cri) {
		return mapper.totalReqCnt(cri);
	}




}

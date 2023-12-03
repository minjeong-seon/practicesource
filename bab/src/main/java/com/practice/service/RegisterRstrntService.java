package com.practice.service;

import java.util.List;

import com.practice.domain.Criteria;
import com.practice.domain.RegisterRstrntDTO;

public interface RegisterRstrntService {
	//맛집등록요청 목록 보기
	public List<RegisterRstrntDTO> listRequest(Criteria cri);
	//맛집등록요청 보내기(등록)
	public boolean sendRequest(RegisterRstrntDTO dto);
	//맛집등록요청 상세보기(1개 조회)
	public RegisterRstrntDTO readRequest(int reqId);
	//맛집등록요청 삭제
	public boolean deleteRequest(int reqId);
	//맛집등록요청 건수
	public int totalReqCnt(Criteria cri);
}

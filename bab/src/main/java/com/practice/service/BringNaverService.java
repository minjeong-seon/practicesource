package com.practice.service;
//네이버 API 응답 결과 가져오는 로직(query에 맞는 목록 가져옴)
import java.util.List;

import com.practice.main.dto.BringNaverApiDTO;


public interface BringNaverService {
	public List<BringNaverApiDTO> main(String query);
	public List<BringNaverApiDTO> search(String query);

}
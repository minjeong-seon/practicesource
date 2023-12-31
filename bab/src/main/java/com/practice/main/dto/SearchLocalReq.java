package com.practice.main.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 지역검색 정보요청 파라메터 DTO
// query=갈비집&display=5&start=1&sort=random <이런 거

@Data @AllArgsConstructor @NoArgsConstructor
public class SearchLocalReq {

	//네이버 API에 보낼 HTTP 요청 파라미터
	private String query = "";
	private String display = "4";
	private String start = "1";
	private String sort = "comment";
	
	public MultiValueMap<String, String> toMultiValueMap(){
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("query", query);
		map.add("display", display);
		map.add("start", start);
		map.add("sort", sort);
		
		return map;
	}
}

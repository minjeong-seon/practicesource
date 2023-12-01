package com.practice.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.domain.RegisterRstrntDTO;
import com.practice.main.dto.BringNaverApiDTO;
import com.practice.service.BringNaverService;
import com.practice.service.RegisterRstrntService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller	//ViewResolver 써야 하니까 일반 컨트롤러~
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private BringNaverService brService;
	@Autowired
	private RegisterRstrntService reqService;
	
	
	// 메인에서 카테고리 클릭 시 작동하는 컨트롤러(카테고리별 맛집 목록 불러옴)
	@GetMapping("/main")
	@ResponseBody	//메인에서 비동기 방식으로 JSON 응답 처리(ViewResolver 거치지 않음)
	public List<BringNaverApiDTO> main(String query) {
		log.info("푸드 카테고리별 맛집 요청"+query);
		
		return brService.main(query);
	}

	
	
	// 서치페이지에서 작동하는 컨트롤러
	@GetMapping("/search")
	public  String search(String query, Model model) {
		log.info("맛집 정보 검색 요청" + query);
		
		List<BringNaverApiDTO> srchList= brService.search(query);

		model.addAttribute("srchList", srchList);
		
		if(srchList.isEmpty()) return "recheck";
		log.info(srchList.toString());
		return "search";
	}
	
	
	//서치페이지 내에서 맛집등록 요청 시 작동하는 컨트롤러(비동기 --주소창 변화x)
	//post로 받은 요청 데이터 로직 처리
	@PostMapping("/search")
	public ResponseEntity<String> requestRegister(@RequestBody RegisterRstrntDTO dto,  Model model) {
		log.info("맛집 등록 요청 내용: ", dto);
		 model.addAttribute("dto",dto);
		return reqService.sendRequest(dto)?
					new ResponseEntity<String>("success",HttpStatus.OK):
						new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}

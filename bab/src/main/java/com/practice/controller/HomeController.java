package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.domain.RegisterRstrntDTO;
import com.practice.main.dto.BringNaverApiDTO;
import com.practice.service.BringNaverService;
import com.practice.service.RegisterRstrntService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("") // 메인에서 동작하는 컨트롤러
public class HomeController {

	@Autowired
	private BringNaverService brService;
	@Autowired
	private RegisterRstrntService reqService;

	// 메인페이지 화면단 api 정보 가져오기(기본값: 한식)
	@GetMapping("/")
	public String home(Model model) {
		log.info("메인 페이지 요청");

		List<BringNaverApiDTO> list = brService.main("한식");

		model.addAttribute("list", list); // 뷰에서 list 변수로 데이터 접근

		return "main";
	}

	// http://localhost:8080/api/master에서 '맛집등록요청' 목록 조회
	@GetMapping("/api/master")
	public String master(Model model) {

		List<RegisterRstrntDTO> list = reqService.listRequest();
		log.info("요청 목록 조회 ");
		model.addAttribute("list", list);
		return "master";
	}

	// http://localhost:8080/api/del/reqId -- '맛집등록요청' 자세히 보기
	@GetMapping({ "/api/del/{reqId}" })
	public String readGet(@PathVariable("reqId") int reqId, Model model) {
		log.info("등록요청 건 번호: " + reqId);

		// post_id 에 맞는 내용 가져오기
		RegisterRstrntDTO dto = reqService.readRequest(reqId);
		log.info("내용조회: " + dto);
		model.addAttribute("dto", dto);

		return "del";
	}

	// 등록요청 삭제(마스터 권한 - del 페이지)
	// 삭제 후 /delete --> /api/master 로 이동
	@GetMapping("/delete")
	public String deleteGet(int reqId, RedirectAttributes rttr) {
		log.info("요청 삭제: " + reqId);

		reqService.deleteRequest(reqId);
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다.");

		return "redirect:/api/master";
	}
}

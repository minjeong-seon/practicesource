package com.practice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.domain.RestaurantDTO;
import com.practice.domain.ResultDTO;
import com.practice.domain.ReviewDTO;
import com.practice.service.RestaurantService;
import com.practice.service.ResultService;
import com.practice.service.ReviewService;
import com.practice.service.WishListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private ResultService resultService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private WishListService wishListService;
	
	
	// 맛집 상세페이지 이동
	// 맛집 정보 테이블에 담기 (담기전 음식점 타이틀과 주소로 중복검사하기)
	@GetMapping("/profile")
	public void profileGet(String restaurantName, Model model) {
	    log.info("맛집 상세페이지 요청: " + restaurantName);
	    ResultDTO result = resultService.result(restaurantName);
	    
	    RestaurantDTO restaurantDTO = new RestaurantDTO();
	    restaurantDTO.setTitle(result.getTitle());
	    restaurantDTO.setAddress(result.getAddress());
	    int restaurantId = restaurantService.saveRestaurant(restaurantDTO);
	    
	    model.addAttribute("result", result);
	    model.addAttribute("restaurantId", restaurantId);
	}
	
	
	// 리뷰 보여주기
	@GetMapping("/list/{restauantId}")
	public ResponseEntity<List<ReviewDTO>> reviewList(@PathVariable("restauantId") int restauantId){
		log.info("리뷰 요청" + restauantId);
		return new ResponseEntity<List<ReviewDTO>>(reviewService.getList(restauantId), HttpStatus.OK);
	}
	
	// 특정 조회
	@GetMapping(value="/{reviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewDTO> get(@PathVariable int reviewId){
		log.info("댓글 조회 "+reviewId);
		return new ResponseEntity<ReviewDTO>(reviewService.read(reviewId), HttpStatus.OK);
	}
	
	// insert 작업
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReviewDTO ReviewDTO, Model model){
	    log.info("댓글 삽입 " + ReviewDTO);

	    model.addAttribute("dto", ReviewDTO);
	    return reviewService.insert(ReviewDTO)?
	            new ResponseEntity<String>("success", HttpStatus.OK):
	                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	// update 작업
	@GetMapping("/update")
	public ResponseEntity<String> modify(@ModelAttribute ReviewDTO ReviewDTO){
		log.info("댓글 수정 "+ReviewDTO);
		
		return reviewService.update(ReviewDTO)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// delete 작업
	@GetMapping("/delete/{reviewId}")
	public ResponseEntity<String> remove(@PathVariable("reviewId") int reviewId){
		log.info("댓글 삭제 "+reviewId);
		return reviewService.delete(reviewId)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
}
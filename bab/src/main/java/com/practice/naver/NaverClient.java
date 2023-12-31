package com.practice.naver;
//네이버 API와 상호작용(통신/요청/응답 처리) 하기 위한 클라이언트 클래스

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.practice.main.dto.SearchImageReq;
import com.practice.main.dto.SearchImageRes;
import com.practice.main.dto.SearchLocalReq;
import com.practice.main.dto.SearchLocalReq2;
import com.practice.main.dto.SearchLocalRes;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NaverClient {

	// application.properties 에 있는 정보 가져오기
	@Value("${naver.client.id}")
	private String naverClientId;

	@Value("${naver.client.secret}")
	private String naverClientSecret;

	@Value("${naver.url.search.local}")
	private String naverLocalSearchUrl;

	@Value("${naver.uri.search.image}")
	private String naverImageSearchUrl;

	// 메인페이지 전용
	// 지역검색 API 호출 메소드
	public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
		// 요청 uri 생성
		URI uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl).queryParams(searchLocalReq.toMultiValueMap())
				.encode().build().toUri();

		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", "duSq6A4xuhsQBxveH3cy");
		headers.set("X-Naver-Client-Secret", "KSpQMKvLZv");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);

		log.info("clientID, {}", naverClientId);
		log.info("naverClientSecret, {}", naverClientSecret);

		// ParameterizedTypeReference: API 응답 형식 지정
		ParameterizedTypeReference<SearchLocalRes> resReference = new ParameterizedTypeReference<SearchLocalRes>() {
		};

		// RestTemplate: HTTP Get 요청 생성 --> API에 전달
		// exchange(요청보낼 URI, HTTP 메소드 지정, 헤더 정보 객체, 응답 형식): API 응답 가져오기
		ResponseEntity<SearchLocalRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity,
				resReference);

		// ResponseEntity에서 응답 본문 추출해서 반환
		return resEntity.getBody();
	}

	
	// 이미지 검색 처리용 메소드
	public SearchImageRes searchImage(SearchImageReq searchImageReq) {

		URI uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl).queryParams(searchImageReq.toMultiValueMap())
				.encode().build().toUri();

		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", "duSq6A4xuhsQBxveH3cy");
		headers.set("X-Naver-Client-Secret", "KSpQMKvLZv");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);

		ParameterizedTypeReference<SearchImageRes> resReference = new ParameterizedTypeReference<SearchImageRes>() {
		};

		ResponseEntity<SearchImageRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity,
				resReference);
		return resEntity.getBody();
	}

	
	// 검색결과 페이지 전용 메소드
	public SearchLocalRes searchLocal2(SearchLocalReq2 searchLocalReq2) {

		URI uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl).queryParams(searchLocalReq2.toMultiValueMap())
				.encode().build().toUri();

		log.info("지역검색 ", uri.toString());

		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", "duSq6A4xuhsQBxveH3cy");
		headers.set("X-Naver-Client-Secret", "KSpQMKvLZv");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);

		log.info("clientID, {}", naverClientId);
		log.info("naverClientSecret, {}", naverClientSecret);

		ParameterizedTypeReference<SearchLocalRes> resReference = new ParameterizedTypeReference<SearchLocalRes>() {
		};

		ResponseEntity<SearchLocalRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity,
				resReference);
		return resEntity.getBody();
	}

}

package com.practice.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// api 응답 결과 내에 상위 객체

@Data @AllArgsConstructor @NoArgsConstructor
public class SearchImageRes {

	private String lastBuildDate;
	private int total;
	private int start;
	private int display;
	private List<SearchImageItem> items;
}

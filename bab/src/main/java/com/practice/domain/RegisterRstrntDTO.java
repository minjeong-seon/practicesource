package com.practice.domain;
//음식점 등록 요청 객체(사용자가 새로운 음식점 정보 등록 요청 시 받을 속성 정의)

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class RegisterRstrntDTO {
	private int reqId;
	private String reqName;
	private String reqAddress;
	private String reqContent;
	private String reqUser;
	private Date reqDate;
}

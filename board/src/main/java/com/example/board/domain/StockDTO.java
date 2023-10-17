/*
 * 한투 open api 데이터 받을 객체
 */
package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class StockDTO {
	private String MKSC_SHRN_ISCD;	// 종목코드
	private long STCK_PRPR;	// 주식 현재가
	private String PRDY_VRSS_SIGN; // 전일 대비 부호(1 : 상한	2 : 상승	3 : 보합	4 : 하한	5 : 하락)
	private double PRDY_CTRT;	// 전일 대비율
	private long STCK_OPRC;	// 시가
	private long STCK_HGPR;	// 최고가
	private long STCK_LWPR;	// 최저가
	private long ASKP1;	// 매도 호가
	private long BIDP1;	// 매수 호가
	private long CNTG_VOL;	// 체결 거래량
	private long CTTR;	// 체결강도
	




}

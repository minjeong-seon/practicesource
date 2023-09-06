/*
 * Spring Boot 애플리케이션을 WAR 파일로 배포(웹서버에서 해당 어플리케이션 실행)하기 위한 Servlet 초기화 설정 파일
 */

package com.example.board;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoardApplication.class); //BoardApplication을 초기화 클래스로 사용
	}

}


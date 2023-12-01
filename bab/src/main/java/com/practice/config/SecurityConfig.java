package com.practice.config;
//스프링 시큐리티 설정

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.practice.handler.CustomLoginSuccessHandler;
import com.practice.service.CustomUserDetailService;


@Configuration	//=환경설정용 클래스임
@EnableWebSecurity	//시큐리티 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	//DB 연동을 위해 DataSource 주입
	@Autowired
	private DataSource dataSource;
	
	//비번 암호화 빈 생성
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//로그인 성공 핸들러 빈 생성
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	//사용자 정보 로드
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailService();
	}	
	
	//사용자 인증 설정(인증 정보 검증 및 권한 부여)
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//customUserService에서 반환된 userDetailsService 구현체 사용해서 사용자 정보 로드
		auth.userDetailsService(customUserService())	
			.passwordEncoder(passwordEncoder());	//비번 인코딩 설정
	}
	
	//HTTP 보안 구성 메소드
	@Bean
	protected SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		//요청 & 응답 내용 UTF-8 인코딩
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter,CsrfFilter.class);
		
		//로그인, 로그아웃 관련 url 이동 설정
		http.formLogin()
		.loginPage("/member/login")
		.loginProcessingUrl("/login")
		.failureUrl("/member/login-error")
		.successHandler(loginSuccessHandler());
		
		http.logout()
		.logoutSuccessUrl("/");
		 
		
		//로그인 정보 기억하기(토큰 값 7일 유지)
		http.rememberMe()
		.tokenRepository(perTokenRepository())
		.tokenValiditySeconds(604800);
		
		//OAuth 2.0 : 다른 웹사이트나 어플 계정으로 로그인할 때 필요한 인증/권한 부여 프레임워크
//		http.oauth2Login()
//	    .loginPage("/member/login")
//	    .authorizationEndpoint()
//	        .baseUri("/oauth2/authorization")
//	        .and()
//	    .defaultSuccessUrl("/login-success")
//	    .failureUrl("/member/login-error2");
//		
		return http.getOrBuild();
		
	}
	
	//remember me 기능 토큰 저장용 리퍼지토리 생성
	@Bean
	public PersistentTokenRepository perTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}	
}

package com.example.board.config;

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

import com.example.board.handler.CustomLoginSuccessHandler;
import com.example.board.service.CustomUserDetailService;

// 5.7.X security 환경 설정 작성 방법은 변경됨
// 이건 5.6.X 버전임...

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailService();
	}
	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter,  CsrfFilter.class);
		
		http.formLogin()
				.loginPage("/member/login")
				.loginProcessingUrl("/login")		//login post 일 때 경로 지정
				.failureUrl("/member/login-error")
				.successHandler(loginSuccessHandler());
			
		http.logout().logoutSuccessUrl("/");
		
		http.rememberMe()
				.tokenRepository(perTokenRepository())
				.tokenValiditySeconds(604800);

		return http.getOrBuild();
	}
	
	
	@Bean
	public PersistentTokenRepository perTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
}


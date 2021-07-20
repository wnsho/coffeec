package com.joon.wlc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것.
//보통 이 세개 같이 쓰임.
@Configuration // 빈등록(IoC관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리!! 체크하겠다는 뜻.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean //IoC
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf토큰 비활성화 (테스트시 걸어두는게 좋음)
			.authorizeRequests()	//요청 들어오면
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/coffeeImg/**")	//여기 경로들은 허가
				.permitAll()	//허가
				.anyRequest()	//다른것들은
				.authenticated()	//인증이 되어야한다.
			.and()
				.formLogin()
				.loginPage("/auth/loginForm");
	}
}

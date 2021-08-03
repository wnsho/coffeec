package com.joon.wlc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joon.wlc.config.auth.PrincipalDetailService;

//빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것.

@Configuration // 빈등록(IoC관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리!! 체크하겠다는 뜻.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //IoC
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인해주는데 password를 가로채기를 하는데
	//해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지를 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬와 비교할 수 있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD()); //패스워드 비교
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
				.loginPage("/auth/loginForm")	//인증안된것은 로그인 폼으로
				.loginProcessingUrl("/auth/loginProc")  //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해줌
				.defaultSuccessUrl("/");
	}
}

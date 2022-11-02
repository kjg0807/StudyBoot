package com.iu.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	// public 선언시 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityCustomizer()
	{
		// Security에서 무시해야하는 URL 패턴 등록
		// web에서 images밑에 있는 것을 사용할 때 Security 무시
		return web -> web.ignoring().antMatchers("/images/**").antMatchers("/css/**").antMatchers("/js/**").antMatchers("/favicon/**")
				.antMatchers("/resources/**");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.cors()
						.and()
						.csrf()
						.disable()
						.authorizeRequests()
						.antMatchers("/").permitAll()
						// /(루트)를 허용한다
						.antMatchers("/login").permitAll().antMatchers("/logout").permitAll()
						// Role이 ADMIN인 사람에게만 /admin을 , Role이 MANAGER인 사람에게만 /manager을
						.antMatchers("/admin").hasRole("ADMIN").antMatchers("/manager").hasRole("MANAGER")
						.antMatchers("/qna/list").permitAll().antMatchers("/qna/**").hasRole("MEMBER")
						.anyRequest().permitAll()
						// 그 외 나머지는 로그인 했을 때만 접근 가능
						// .anyRequest().authenticated()
						.and()
						// 로그인창에 접근 하는 것을 허용
						.formLogin() //로그인 폼 인증 설정
							.loginPage("/member/login") // 내장된 로그인 폼을 사용하지 않고, 개발자가 만든 폼을 요청하는 URL작성 - 필수
							// .loginProcessingUrl("login") // 로그인을 진행 요청할 form태그의 action의 주소 지정 - 필수는 아님
							// 패스워드 파라미터는 password이지만 개발자가 다른 파라미터 이름을 사용했을 때 사용
							.passwordParameter("pwd") // password의 파라미터가 pwd라고 알려줌 -> jsp name = pwd
							// 아이디 파라미터는 username이지만 개발자가 다른 파라미터 이름을 사용했을 때 사용
							.usernameParameter("id") // username의 파라미터가 id라고 알려줌 -> jsp name=id
							.defaultSuccessUrl("/") // 인증에 성공할 경우 요청할 URL
							.failureForwardUrl("/member/login") // 인증에 실패했을 때 요청할 URL
							.permitAll()
							.and()
						.logout()
							.permitAll()
				;

		return httpSecurity.build();
	}
}

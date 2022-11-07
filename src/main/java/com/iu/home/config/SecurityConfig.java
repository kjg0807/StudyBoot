package com.iu.home.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.iu.home.member.MemberSecurityService;
import com.iu.home.member.security.LoginFail;
import com.iu.home.member.security.LoginSuccess;
import com.iu.home.member.security.LogoutCustom;
import com.iu.home.member.security.LogoutSuccessCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Autowired
	private LoginSuccess loginSuccess;

	@Autowired
	private LoginFail loginFail;
	@Autowired
	private LogoutCustom logoutCustom;
	@Autowired
	private LogoutSuccessCustom logoutSuccessCustom;
	@Autowired
	private MemberSecurityService memberSecurityService;

	@Bean
	// public 선언시 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityCustomizer()
	{
		// Security에서 무시해야하는 URL 패턴 등록
		// web에서 images밑에 있는 것을 사용할 때 Security 무시
		return web -> web.ignoring().antMatchers("/images/**").antMatchers("/css/**").antMatchers("/js/**").antMatchers("/favicon/**").antMatchers("/resources/**");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity //
				.csrf() // 적용되면 서버에서 토큰을 줌
				.disable() //
				.cors() //
				.configurationSource(this.corsConfigurationSource()) //
				.and() //

				.authorizeRequests() // 인증된 사용자의 접근을 허용
				.antMatchers("/") // 사용자
				.permitAll() // 전체 허용
				// ----- 권한 부여 시작 -----
				.antMatchers("/login").permitAll().antMatchers("/logout").permitAll()
				// Role이 ADMIN인 사람에게만 /admin을
				.antMatchers("/admin").hasRole("ADMIN")
				// Role이 ADMIN, MANAGER인 사람에게만 /manager을
				.antMatchers("/manager").hasAnyRole("ADMIN", "MANAGER")
				// Role이 ADMIN, MANAGER, MEMBER인 사람에게만 /mypage들어감
				.antMatchers("/member/mypage").hasAnyRole("ADMIN", "MANAGER", "MEMBER")
				//
				.antMatchers("/qna/list").permitAll()//
				// .antMatchers("/qna/**").hasRole("MEMBER")//
				// ----- 권한 부여 끝 -----
				.anyRequest().permitAll()
				// 그 외 나머지는 로그인 했을 때만 접근 가능
				// .anyRequest().authenticated()
				.and()
				// 로그인창에 접근 하는 것을 허용
				// ---------- 로그인 시작 ---------------
				.formLogin() // 로그인 폼 인증 설정
				.loginPage("/member/login") // 내장된 로그인 폼을 사용하지 않고, 개발자가 만든 폼을 요청하는 URL작성 - 필수
				// .loginProcessingUrl("login") // 로그인을 진행 요청할 form태그의 action의 주소 지정 - 필수는 아님
				// 패스워드 파라미터는 password이지만 개발자가 다른 파라미터 이름을 사용했을 때 사용
				.passwordParameter("pwd") // password의 파라미터가 pwd라고 알려줌 -> jsp name = pwd
				// 아이디 파라미터는 username이지만 개발자가 다른 파라미터 이름을 사용했을 때 사용
				.usernameParameter("id") // username의 파라미터가 id라고 알려줌 -> jsp name=id
				// .defaultSuccessUrl("/") // 인증에 성공할 경우 요청할 URL
				.successHandler(loginSuccess) // 성공했을 때 추가 작업
				// .failureUrl("/member/login?error=true&message=LoginFail") // 인증에 실패했을 때 요청할 URL
				.failureHandler(loginFail) //
				.permitAll() // 전부 허용
				// ---------- 로그인 끝 ---------------
				.and() // 그리고

				// ---------- 로그아웃 시작 ---------------
				.logout() // 로그 아웃시
				.logoutUrl("/member/logout") // 로그아웃
				// .logoutSuccessUrl("/") // 로그아웃 성공시
				.addLogoutHandler(logoutCustom) // 로그아웃 시 실행
				.logoutSuccessHandler(logoutSuccessCustom) // 로그아웃 성공 시 실행
				.invalidateHttpSession(true) // Session 내용 없애기
				.deleteCookies("JSESSIONID") // 쿠키 삭제
				.permitAll() //
				// ---------- 로그아웃 끝 ---------------
				.and() //
				// ------------- 로그인 정보 기억 시작 -------------
				.rememberMe() // 정보 기억 설정
				.rememberMeParameter("rememberMe") // 파라미터명 (원래 기본 파라미터 remember-me)
				.tokenValiditySeconds(300) // 단위: 초 - n초 동안 로그인 유지
				.key("rememberMe") // 인증받은 사용자의 정보로 Token을 생성시 필요 *필수 값*
				.userDetailsService(memberSecurityService) // 인증 절차를 실행할 UserDetailService *필수*
				// SecurityService의 loadUserByUsername 클래스 필요 - public UserDetails loadUserByUsername
				.authenticationSuccessHandler(loginSuccess); // 로그인 성공 시 이 Handler 실행
		// ------------- 로그인 정보 기억 끝 -------------
		;

		return httpSecurity.build();
	}

	// 평문(Clear Text)을 암호화 시켜주는 객체 생성
	@Bean
	public PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	// @Bean // 다른 곳에서 객체로 사용하기 위해 사용
	CorsConfigurationSource corsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://192.168.1.36:5500", "*"));
		// Arrays.asList("1") -> list<String> : Type, a String 타입 여러 개 입력 가능
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
}

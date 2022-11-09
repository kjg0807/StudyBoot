package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutSuccessCustom implements LogoutSuccessHandler
{
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String client_id;
	@Value("${kakao.redirect-uri.logout}")
	private String redirect_uri;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		log.info("====== logout Success =====");

		MemberVO memberVO = new MemberVO();
		memberVO = (MemberVO) authentication.getPrincipal();
		String social = memberVO.getSocial();
		if (social != null)
		{
			if (social.equals("kakao"))
			{
				// RestTemplate restTemplate = new RestTemplate();
				// // header, parameter: request X
				//
				// MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
				// map.add("client_id", "b8a8491711f92b3ee52bc51b11e7882c");
				//
				// HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(map, null);
				//
				// ResponseEntity<String> res = restTemplate.getForEntity("https://developers.kakao.com/logout", null, String.class);
				// log.info("res: {}", res);
				// response.sendRedirect("/");
				try
				{
					response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=" + client_id + "&logout_redirect_uri=" + redirect_uri);
					log.info("kakao logout");
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (social.equals("google"))
			{

			}
			else if (social.equals("naver"))
			{

			}
			// log.info("social: {}", );

		}
		// 일반 로그인
		else
		{
			log.info("normal logout");
			response.sendRedirect("/");
		}

	}
}

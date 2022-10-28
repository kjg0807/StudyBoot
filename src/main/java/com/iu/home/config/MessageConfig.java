package com.iu.home.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration // 설정하기 : **.context.xml이랑 동일
@Slf4j
public class MessageConfig implements WebMvcConfigurer
{
	@Bean
	public LocaleResolver local()
	{
		// 1. Session
		SessionLocaleResolver sessionResolver = new SessionLocaleResolver();
		sessionResolver.setDefaultLocale(Locale.KOREAN); // 기본언어: 한국어

		// 2. Cookie
		CookieLocaleResolver cookieResolver = new CookieLocaleResolver();
		cookieResolver.setCookieName("lang"); // 이름 마음대로
		cookieResolver.setDefaultLocale(Locale.KOREAN); // 기본언어: 한국어

		return cookieResolver;
	}

	// **.context.xml
	// <bean class="" id=""> == new 생성자()
	// 위와 아래 동일
	// @Bean("my") // -> 이름 : my
	// public String getString()
	// {
	// return new String();
	// }

	// Interceptor 객체
	@Bean
	public LocaleChangeInterceptor changeInterceptor()
	{
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		// parameter 를 받아서 언어 구분
		// url?lang=ko, en, jp

		return changeInterceptor;
	}
}

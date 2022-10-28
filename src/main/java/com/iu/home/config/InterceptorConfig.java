package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer
{
	@Autowired // IOC(Inversion Of Control)
	private TestInterceptor testInterceptor;
	@Autowired
	private StudyInterceptor studyInterceptor;
	@Autowired
	private LocaleChangeInterceptor changeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		// method chaining
		// 적용할 Interceptor 등록
		registry.addInterceptor(testInterceptor)
				// Interceptor를 적용할 URL등록
				.addPathPatterns("/qna/**").addPathPatterns("/notice/**")
				// 제외할 URL등록
				.excludePathPatterns("/qna/list");

		// 추가 Interceeptor 등록
		registry.addInterceptor(studyInterceptor).addPathPatterns("/qna/**").addPathPatterns("/member/**");
		
		// message Interceptor 등록
		registry.addInterceptor(changeInterceptor).addPathPatterns("/**");
	}
}

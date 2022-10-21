package com.iu.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.iu.home.aop.test.Transport.plane())")
	public void before()
	{
		log.info("----- Before -----");
	}

	@After("execution(* com.iu.home.aop.test.Transport.plane())")
	public void after()
	{
		log.info("----- After -----");
	}

	// com.iu.home.aop.test 패키지 안에 Transport 클래스안에 take으로 시작하는 모든 메서드
	// afterthrowing - 예외가 발생했을 때
	// * | com.iu.home.board.*|.*.|set*())"
	// 모든 리턴타입 | 패키지명(com.iu.home.board.*) | 모든 클래스 | set으로 시작하는 모든 메서드
	@Around(value = "execution(* com.iu.home.aop.test.Transport.take*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable
	{
		log.info("--- 삐빅 승차입니다. ---");
		Object obj = joinPoint.proceed();
		log.info("--- 삐빅 하차입니다. ---");
		return obj;
	}
}

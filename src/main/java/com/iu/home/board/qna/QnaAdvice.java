package com.iu.home.board.qna;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class QnaAdvice
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@After(value = "execution(* com.iu.home.board.qna.QnaService.get*(..))")
	public void beforeTest(JoinPoint joinpoint)
	{
		log.info("------------ before --------------");
		log.info("Args: {}", joinpoint.getArgs());
		log.info("Kind: {}", joinpoint.getKind());
	}

	// @Around(value = "execution(* com.iu.home.board.qna.QnaService.set*(..))")
	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable
	{
		log.info("------------ before --------------");
		// point-cut의 클래스 객체
		log.info("Target: {}", joinPoint.getTarget());
		// point-cut의 클래스 객체
		log.info("This: {}", joinPoint.getThis());
		// point-cut으로 전달되는ㄴ 매개변수의 인자 값
		log.info("Args: {}", joinPoint.getArgs());
		Object[] objs = joinPoint.getArgs();
		QnaVO qnaVO = (QnaVO) objs[0]; // 다형성

		Object obj = joinPoint.proceed();
		log.info("------------ after --------------");
		log.info("Obj: {}", obj);

		return obj;
	}
}

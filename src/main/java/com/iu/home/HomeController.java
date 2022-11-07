package com.iu.home;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.member.MemberVO;

@Controller
public class HomeController
{
	@Value("${my.message.hi}")
	private String message;

	@Value("${my.default}")
	private String app;

	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return "admin Role";
	}

	@GetMapping("/manager")
	@ResponseBody
	public String manager()
	{
		return "Manager Role";
	}

	@GetMapping("/user")
	@ResponseBody
	public String member()
	{
		return "Member Role";
	}

	// final - 값 못 바꿈
	// private final org.slf4j.Logger log =
	// LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String home(HttpSession session) throws Exception
	{
		log.info("============================");
		// session.getAttributeNames() : String collection
		Enumeration<String> en = session.getAttributeNames();

		// Element가 있으면 true - boolean
		while (en.hasMoreElements())
		{
			String key = en.nextElement();
			log.info("KEY: {}", key);
		}
		// Impl : implements
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (context != null)
		{
			log.info("Context: {}", ((MemberVO) context.getAuthentication().getPrincipal()));
		}

		log.info("message: {}", message);
		log.info("default: {}", app);
		log.info("============================");

		return "index";
	}
}

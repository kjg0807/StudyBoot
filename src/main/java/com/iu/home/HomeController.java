package com.iu.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;

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
	public String home() throws Exception
	{
		log.info("============================");
		log.info("message: {}", message);
		log.info("default: {}", app);
		log.info("============================");

		return "index";
	}
}

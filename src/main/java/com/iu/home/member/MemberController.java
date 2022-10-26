package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/member/*")
public class MemberController
{
	@Autowired
	private MemberService memberService;

	@GetMapping(value = "login")
	public String getLogin() throws Exception
	{
		log.info("=== get Login ===");

		return "member/login";
	}

	@PostMapping(value = "login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception
	{
		log.info("=== post Login ===");
		ModelAndView mv = new ModelAndView();

		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		memberVO = (MemberVO) session.getAttribute("member");

		String message = "로그인 실패";
		String url = "../member/login";
		if (memberVO != null)
		{ // login succeed
			message = "로그인 성공";
			url = "../../";
		}
		mv.addObject("dto", memberVO);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("member/rs");

		return mv;
	}

	@GetMapping(value = "logout")
	public ModelAndView logout(HttpSession session, MemberVO memberVO) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		log.info("=== logout ===");
		session.invalidate();
		String message = "로그아웃 되었습니다.";
		String url = "../../";

		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("member/rs");

		return mv;
	}

	@GetMapping(value = "join")
	public String setJoin() throws Exception
	{
		log.info("=== get Join ===");

		return "member/join";
	}

	@PostMapping(value = "join")
	public ModelAndView setJoin(MemberVO memberVO) throws Exception
	{
		log.info("=== post Join ===");
		ModelAndView mv = new ModelAndView();

		int rs = memberService.setJoin(memberVO);
		log.info("rs: {}", rs);

		mv.addObject("join", memberVO);
		mv.setViewName("redirect:./login");

		return mv;
	}

	@RequestMapping(value = "getIdCheck")
	@ResponseBody
	public int getIdCheck(String memberVO) throws Exception
	{
		log.info("===== Id Check =====");

		int rs = memberService.getCheckId(memberVO);
		log.info("--- rs: {} ---", rs);

		return rs;
	}
}

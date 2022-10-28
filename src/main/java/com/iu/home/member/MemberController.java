package com.iu.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String setJoin(@ModelAttribute MemberVO memberVO) throws Exception
	{
		log.info("=== get Join ===");
		// MemberVO memberVO = new MemberVO();
		// model.addAttribute(memberVO);

		return "member/join";
	}

	@PostMapping(value = "join")
	public ModelAndView setJoin(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult) throws Exception
	// memberVO를 검증하기 위해 @Valid 선언 -> 이 값을 BindingResult에 저장(선언만 하면 담아짐)
	{
		log.info("=== post Join ===");
		if (bindingResult.hasErrors()) // 검증에 실패했다면
		{
			log.info("===== 검증 에러 발생 =====");
			// 검증에 실패하면 회원가입하는 JSP로 이동(forward)
			mv.setViewName("member/join");
			return mv;
		}

		// int rs = memberService.setJoin(memberVO);
		// log.info("rs: {}", rs);

		mv.addObject("join", memberVO);
		mv.setViewName("redirect:./login");

		return mv;
	}

	@RequestMapping(value = "getIdCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception
	{
		log.info("===== Id Check =====");

		int rs = memberService.getCheckId(memberVO);

		log.info("=== rs: {} ===", rs);

		return rs;
	}
}

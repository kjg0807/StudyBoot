package com.iu.home.board.qna;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController
{
	@Autowired
	private QnaService qnaService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "list")
	public ModelAndView list(Pager pager) throws Exception
	{
		log.info("GET LIST");

		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/list");

		return mv;
	}

	@GetMapping(value = "write")
	public String write() throws Exception
	{
		log.info("GET WRITE");

		return "qna/write";
	}

	@PostMapping(value = "write")
	public String write(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception
	{
		log.info("POST WRITE");

		int rs = qnaService.setAddList(qnaVO);

		redirectAttributes.addAttribute("rs", rs);

		return "redirect:./list";
	}

	@GetMapping(value = "detail")
	public ModelAndView detail(QnaVO qnaVO) throws Exception
	{
		// log.info("Detail getNum: {}", qnaVO.getNum());
		ModelAndView mv = new ModelAndView();

		qnaVO = qnaService.getDetail(qnaVO);

		mv.addObject("detail", qnaVO);
		mv.setViewName("qna/detail");

		return mv;
	}
}

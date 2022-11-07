package com.iu.home.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/qna/*")
@Slf4j
public class QnaController
{
	@Autowired
	private QnaService qnaService;

	@GetMapping("hack")
	@ResponseBody
	public int hack(QnaVO qnaVO) throws Exception
	{
		qnaService.setAddList(qnaVO);

		return 1;
	}

	@GetMapping(value = "list")
	public ModelAndView list(Pager pager) throws Exception
	{
		log.info("GET LIST");

		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		log.info("list - num: {}", ar);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/list");

		return mv;
	}

	@GetMapping(value = "write")
	public String write(@ModelAttribute QnaVO qnaVO) throws Exception
	{
		log.info("GET WRITE");

		return "qna/write";
	}

	@PostMapping(value = "write")
	public ModelAndView write(ModelAndView mv, @Valid QnaVO qnaVO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception
	{
		log.info("POST WRITE");
		if (bindingResult.hasErrors())
		{
			log.info("===== qna write error =====");
			mv.setViewName("qna/write");
			return mv;
		}

		int rs = qnaService.setAddList(qnaVO);

		redirectAttributes.addAttribute("rs", rs);
		mv.setViewName("redirect:./list");

		return mv;
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
	// qna/update get - parameter: num, update.jsp

	@GetMapping(value = "update")
	public ModelAndView update(QnaVO qnaVO, Pager pager) throws Exception
	{
		log.info("=== Get Update ===");

		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		log.info("writer: {}", qnaVO.getNum());

		mv.addObject("list", qnaVO);
		mv.setViewName("qna/update");

		return mv;
	}

	@ResponseBody
	@RequestMapping("fileDelete")
	public int fileDelete(QnaFileVO qnaFileVO) throws Exception
	{
		int rs = qnaService.DeleteQnaFile(qnaFileVO);

		log.info("===== rs : {}=====", rs);
		log.info("===== Filenum : {}=====", qnaFileVO.getFileNum());

		return rs;
	}
}

package com.iu.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController
{
	@Autowired
	private QnaMapper qnaMapper;
//	@Autowired
//	private QnaService qnaService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "list")
	public ModelAndView list(QnaVO qnaVO) throws Exception
	{
		log.info("GET LIST");
		
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaMapper.getList();
//		
//		
//		for(QnaVO qnaVO1 : ar) {
////			System.out.println(qnaVO1.getNum());
////			log.info(qnaVO1.getTitle());
////			log.info(qnaVO1.getWriter());
//		}
//		
		mv.addObject("list", ar);
//		mv.addObject("pager", pager);
		mv.setViewName("qna/list");

		return mv;
	}
}

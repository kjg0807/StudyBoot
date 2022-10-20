package com.iu.home.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

@Controller
public class FileManageController
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/fileDown/{path}") // {path} : RestFul, RestAPI와 관련
	public ModelAndView fileDown(QnaFileVO qnaFileVO, @PathVariable String path) throws Exception
	{// @pathVariable - String path를 {path}로 활용하겟다
		log.info("path: {}", path);
		ModelAndView mv = new ModelAndView();
		// DB에서 정보 조회
		if (path.equals("qna"))
		{
			qnaFileVO.setFileName("2f8760fc-7064-41a4-bc3a-c3445f875c2d_aa.JPG");
			qnaFileVO.setOriName("aa.jpg");
			// qnaService 출력
		} else if (path.equals("notice"))
		{
			// noticeService 출력
		}

		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");

		return mv;
	}
}

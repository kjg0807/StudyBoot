package com.iu.home.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

@Controller
public class FileManageController
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QnaService qnaService;

	// @RequestBody 요청하는 body에서 값을 가져옴? - JSP에서 값 보낼때?
	// @GetMapping(value = "/fileDown/{path}/{num}") // {path} : RestFul, RestAPI와 관련
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView fileDown(@RequestBody QnaFileVO qnaFileVO, @PathVariable String path, @PathVariable int num) throws Exception
	{// @pathVariable - String path를 {path}로 활용하겟다
		log.info("path: {}", path);
		ModelAndView mv = new ModelAndView();
		// DB에서 정보 조회
		if (path.equals("qna"))
		{
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);

			// qnaFileVO.setFileName("2f8760fc-7064-41a4-bc3a-c3445f875c2d_aa.JPG");
			// qnaFileVO.setOriName("aa.jpg");
			// qnaService 출력
		}
		else if (path.equals("notice"))
		{
			// noticeService 출력
		}

		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		// BeanNameResolver :
		// view의 이름과 일치하는 bean의 이름이 있으면 해당 bean을 실행

		// InternalResourceViewResilver
		// /WEB-INF/views/fileManager.jsp

		return mv;
	}
}

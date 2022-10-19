package com.iu.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
public class QnaService
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaMapper qnaMapper;

	public List<QnaVO> getList(Pager pager) throws Exception
	{
		pager.makeRow();
		return qnaMapper.getList(pager);
	}

	public int setAddList(QnaVO qnaVO) throws Exception
	{
		for (MultipartFile f : qnaVO.getFiles())
		{
			// isEmpty : 비어있는지
			if (!f.isEmpty())
			{
				log.info("Filename: {}", f.getOriginalFilename());
			}
		}
		return 1;
//		return qnaMapper.setAddList(qnaVO);
	}
}

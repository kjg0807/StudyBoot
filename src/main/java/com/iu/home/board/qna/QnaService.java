package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class) // 실행하다 Exception 발생시 롤백
public class QnaService
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;

	@Value("${app.upload.qna}")
	private String path;

	public List<QnaVO> getList(Pager pager) throws Exception
	{
		pager.makeRow();
		return qnaMapper.getList(pager);
	}

	public int setAddList(QnaVO qnaVO) throws Exception
	{
		int rs = qnaMapper.setAddList(qnaVO);

		// log.info("RealPath: {}", path);
		File file = new File(path);
		// exists - 존재하는지
		if (!file.exists())
		{
			boolean ch = file.mkdirs();
		}

		for (MultipartFile f : qnaVO.getFiles())
		{
			// if (f.isEmpty())
			// {
			// log.info("----- Occur Exception -----");
			// throw new Exception(); // Exception 강제 발생
			// }
			// isEmpty : 비어있는지
			if (!f.isEmpty())
			{
				log.info("Filename: {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		return rs;
	}

	public QnaVO getDetail(QnaVO qnaVO) throws Exception
	{
		return qnaMapper.getDetail(qnaVO);
	}

	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception
	{
		return qnaMapper.getFileDetail(qnaFileVO);
	}
}

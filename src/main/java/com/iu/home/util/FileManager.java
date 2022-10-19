package com.iu.home.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public String saveFile(MultipartFile mf, String path) throws IOException
	{
		// 1. 중복되지 않는 파일 명 생성(UUID, Date)
		String fileName = UUID.randomUUID().toString();

		// 2. 확장자 - MultipartFile의 orginal Filename
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		bf.append(mf.getOriginalFilename());
		// log.info("FileName: {}", bf.toString());

		// 3. File 저장하기
		File file = new File(path, bf.toString());

		// FileCopyUtils
		// FileCopyUtils.copy(mf.getBytes(), file);

		// MultipartFile
		mf.transferTo(file);

		return fileName;
	}
}

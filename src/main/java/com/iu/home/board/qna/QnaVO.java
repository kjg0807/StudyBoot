package com.iu.home.board.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.iu.home.member.RoleVO;

import lombok.Data;

@Data
public class QnaVO
{
	private Long num;
	@NotBlank(message = "제목은 필수 입력입니다.")
	@Min(5)
	private String title;
	@NotBlank
	@Min(2)
	private String writer;
	@NotBlank
	@Min(10)
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	private List<QnaFileVO> qnaFileVOs;
	private RoleVO roleVO;

	private MultipartFile[] files;

}

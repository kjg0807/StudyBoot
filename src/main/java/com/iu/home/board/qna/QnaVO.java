package com.iu.home.board.qna;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class QnaVO
{
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	
	private MultipartFile[] files;

	public MultipartFile[] getFiles()
	{
		return files;
	}

	public void setFiles(MultipartFile[] files)
	{
		this.files = files;
	}

	public Long getNum()
	{
		return num;
	}

	public void setNum(Long num)
	{
		this.num = num;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public Long getHit()
	{
		return hit;
	}

	public void setHit(Long hit)
	{
		this.hit = hit;
	}

	public Date getRegDate()
	{
		return regDate;
	}

	public void setRegDate(Date regDate)
	{
		this.regDate = regDate;
	}

	public Long getRef()
	{
		return ref;
	}

	public void setRef(Long ref)
	{
		this.ref = ref;
	}

	public Long getDepth()
	{
		return depth;
	}

	public void setDepth(Long depth)
	{
		this.depth = depth;
	}

	public Long getStep()
	{
		return step;
	}

	public void setStep(Long step)
	{
		this.step = step;
	}
}

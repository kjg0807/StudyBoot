package com.iu.home.util;

public class Pager
{
	// 시작번호
	private Long startRow;

	// 끝번호
	private Long lastRow;
	private Long reviewNum;

	// 현재페이지
	private Long page;

	// perPage : 한페이지에(JSP) 출력할 글의 갯수
	private Long perPage;

	private Long totalPage;

	// 전체 페이지 갯수 계산
	public void makePage(Long totalCount)
	{
		this.totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0)
		{
			this.totalPage++;
		}

		// 전체 페이지 = totalCount 나누기 (perPage : 한페이지에(JSP) 출력할 글의 갯수)
		// 만약 totalCount와 JSP에 출력할 글의 갯수의 나누기값 나머지가 0 이 아니라면
		// 전체 페이지를 증가시켜라.

	}

	// startRow
	public void getRowNum()
	{
		startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		lastRow = this.getPage() * this.getPerPage();
	}

	public Long getStratRow()
	{
		return startRow;
	}

	public void setStratRow(Long stratRow)
	{
		this.startRow = stratRow;
	}

	public Long getLastRow()
	{
		return lastRow;
	}

	public void setLastRow(Long lastRow)
	{
		this.lastRow = lastRow;
	}

	public Long getReviewNum()
	{
		return reviewNum;
	}

	public void setReviewNum(Long reviewNum)
	{
		this.reviewNum = reviewNum;
	}

	public Long getPage()
	{
		if (this.page == null || this.page < 1)
		{
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page)
	{
		this.page = page;
	}

	public Long getPerPage()
	{
		if (this.perPage == null || this.perPage < 1)
		{
			this.perPage = 5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage)
	{
		this.perPage = perPage;
	}

	public Long getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(Long totalPage)
	{
		this.totalPage = totalPage;
	}

}

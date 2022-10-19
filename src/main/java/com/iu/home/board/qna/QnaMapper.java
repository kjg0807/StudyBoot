package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//@Repository 생략 가능
@Mapper
public interface QnaMapper
{
	public List<QnaVO> getList() throws Exception;
	
	public int setAddList(QnaVO qnaVO) throws Exception;
}

//package com.iu.home.board.qna;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.iu.home.util.Pager;
//
//@Service
//public class QnaService
//{
//	@Autowired
//	private SqlSession sqlSession;
//	private final String NAMESPACE = "com.iu.home.board.qna.QnaService.";
//
//	public List<QnaVO> getList(Pager pager) throws Exception
//	{
//		return sqlSession.selectList(NAMESPACE + "getList", pager);
//	}
//}

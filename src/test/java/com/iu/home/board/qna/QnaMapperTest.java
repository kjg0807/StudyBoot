package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QnaMapper qnaMapper;

	@BeforeAll
	static void beforeAll()
	{
		System.out.println("전체 Test 실행 전!!");
	}

	@AfterAll
	static void afterAll()
	{
		System.out.println("전체 Test 실행 후!!");
	}

	// @BeforeEach
	// static void beforeEach()
	// {
	// System.out.println("Test 메서드 실행 전");
	// qnaVO = new QnaVO();
	// qnaVO.setNum(1L);
	// }
	//
	// @AfterEach
	// static void afterEach()
	// {
	// System.out.println("Test 메서드 실행 후");
	// }

	// @Test
	// void test2()
	// {
	// log.info("Test2 case");
	// }

//	@Test
//	void setAddList() throws Exception
//	{
//		QnaVO qnaVO = new QnaVO();
//
//		for (int i = 0; i < 100; i++)
//		{
//			qnaVO.setWriter("Test writer");
//			qnaVO.setTitle("Test title");
//			qnaVO.setContents("Test Contents");
//			qnaVO.setHit(1L);
//			qnaVO.setRegDate(null);
//			qnaVO.setRef(12L);
//			qnaVO.setStep(123L);
//			qnaVO.setDepth(1234L);
//
//			int ar = qnaMapper.setAddList(qnaVO);
//
//			// assertNotEquals(0, ar);
//		}
//
//	}

	// @Test
	// void test() throws Exception
	// {
	// List<QnaVO> ar = qnaMapper.getList();
	//
	// log.info("List: {}", ar);
	// assertNotEquals(0, ar.size());
	// }

}

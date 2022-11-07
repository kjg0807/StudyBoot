package com.iu.home.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberServiceTest
{
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void Test() throws Exception
	{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("1");
		memberVO.setPwd(passwordEncoder.encode("1"));
		memberVO.setName("admin");
		memberVO.setEmail("admin@email");

		int rs = memberMapper.setJoin(memberVO);
		assertEquals(1, rs);
	}

}

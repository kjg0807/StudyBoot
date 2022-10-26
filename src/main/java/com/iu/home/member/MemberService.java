package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService
{
	@Autowired
	private MemberMapper memberMapper;

	public MemberVO getLogin(MemberVO memberVO) throws Exception
	{
		return memberMapper.getLogin(memberVO);
	}

	public int setJoin(MemberVO memberVO) throws Exception
	{
		return memberMapper.setJoin(memberVO);
	}

	public int getCheckId(String memberVO) throws Exception
	{
		return memberMapper.getCheckId(memberVO);
	}
}

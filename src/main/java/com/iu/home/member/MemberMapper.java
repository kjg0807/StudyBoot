package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper
{
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setRole(RoleVO roleVO) throws Exception;
	
	public int getCheckId(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(MemberVO memberVO)throws Exception;
}

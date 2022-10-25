package com.iu.home.member;

import lombok.Data;

@Data
public class MemberVO
{
	private Long num;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private boolean enabled;
	
	private RoleVO roleVO;
	private MemberRoleVO memberRoleVO;
	
	
}

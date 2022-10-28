package com.iu.home.member;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO
{
	@Null
	private Long num;
	@NotBlank
	private String id;
	@NotBlank
	@Pattern(regexp = "/^?[0-9]$/")
	// /^?[0-9]{3,4}-?[0-9]{4}$/
	@Size(min = 4, max = 12)
	private String pwd;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;

	private boolean enabled;

	private RoleVO roleVO;
	private MemberRoleVO memberRoleVO;

	private String pwCheck;

	@Range(min = 1, max = 150)
	private int age;
	// 태어난 일
	@Past
	private Date birth;
}

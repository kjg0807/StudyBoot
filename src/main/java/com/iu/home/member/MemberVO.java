package com.iu.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails
{
	@Null
	private Long num;
	@NotBlank
	private String id;
	@NotBlank
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

	private List<RoleVO> roleVOs;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() // 권한을 받는 것?
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleVO roleVO1 : roleVOs)
		{
			authorities.add(new SimpleGrantedAuthority(roleVO1.getRoleName()));
		}

		return authorities;
	}

	@Override
	public String getPassword()
	{
		// pwd 반환
		return this.pwd;
	}

	@Override
	public String getUsername()
	{
		// id 반환
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		// 사용자 계정의 만료 여부
		// true: 만료되지 않음, false: 만료 됨, 로그인 불가
		return true;
		// return false;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		// 계정 잠김 여부
		// true: 계정이 잠기지 않음
		// false: 계정이 잠김, 로그인 불가
		return true;
		// return false;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		// 비밀번호 만료여부
		// true: 만료 안됨
		// false: 만료 됨, 로그인 안됨
		return true;
		// return false;
	}

	// isEnabled
	// 계정 사용 여부
	// true: 계정 활성화, 사용 가능
	// false: 계정 비활성화, 사용 불가능

	public boolean isEnabled()
	{
		return true;
		// return false;
	}
}

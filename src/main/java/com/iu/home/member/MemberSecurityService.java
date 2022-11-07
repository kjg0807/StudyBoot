package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSecurityService implements UserDetailsService
{
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{ // UserDetails : 로그인 정보와 인증 정보 리턴?
		log.info("===== 로그인 시도중 ===== ");
		MemberVO memberVO = memberMapper.getLogin(username);
		log.info("MemberVO : {}", memberVO);

		return memberVO;
	}
}

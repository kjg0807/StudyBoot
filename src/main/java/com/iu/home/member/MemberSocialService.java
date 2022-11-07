package com.iu.home.member;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSocialService extends DefaultOAuth2UserService
{
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException
	{
		log.info("===== Social Login try =====");
		// log.info("userRequest: {}", userRequest);
		log.info("userRequest AccessToken: {}", userRequest.getAccessToken());
		log.info("userRequest AdditionalParameters: {}", userRequest.getAdditionalParameters());
		log.info("userRequest Registration: {}", userRequest.getClientRegistration());

		log.info("===== user infomation =====");
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info("oauth2user-Name: {}", oAuth2User.getName());
		log.info("oauth2user-Attr: {}", oAuth2User.getAttributes());
		log.info("oauth2user-Auth: {}", oAuth2User.getAuthorities());

		return null;
	}

	private OAuth2User socialJoinCheck()
	{
		// 회원가입 유무
	}
}

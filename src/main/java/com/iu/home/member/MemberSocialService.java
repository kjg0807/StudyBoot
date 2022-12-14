package com.iu.home.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

		log.info("==================================");
		String social = userRequest.getClientRegistration().getRegistrationId();
		log.info(social);

		// if (social.equals("kakao"))
		// {
		//
		// }
		// else if 로 naver, google 추가할 수 있음
		OAuth2User oAuth2User2 = this.socialJoinCheck(userRequest);

		return oAuth2User2;
		// return null;
	}

	private OAuth2User socialJoinCheck(OAuth2UserRequest userRequest)
	{
		// 회원가입 유무
		log.info("===== user infomation =====");
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info("oauth2user-Name: {}", oAuth2User.getName());
		log.info("oauth2user-Attr: {}", oAuth2User.getAttributes());
		log.info("oauth2user-Auth: {}", oAuth2User.getAuthorities());

		log.info("===================================");
		Map<String, Object> map = oAuth2User.getAttributes();

		Iterator<String> keys = map.keySet().iterator(); // key 꺼내기
		while (keys.hasNext()) // key가 있으면 true
		{
			String key = keys.next();
			log.info("Key: {}", key);
			// map.get(key);
		}
		log.info("oAuth-pro-ClassName: {}", oAuth2User.getAttribute("properties").getClass());
		LinkedHashMap<String, Object> lm = oAuth2User.getAttribute("properties");
		LinkedHashMap<String, Object> ka = oAuth2User.getAttribute("kakao_account");

		MemberVO memberVO = new MemberVO();
		memberVO.setId(oAuth2User.getName()); // id
		// memberVO.setPwd(null); // pwd가 없으므로, 비우거나 랜덤한 값으로 생성
		memberVO.setName((String) lm.get("nickname"));
		memberVO.setEmail(ka.get("email").toString());

		memberVO.setSocial(userRequest.getClientRegistration().getRegistrationId()); // 소셜 이름 가져옴 : kakao
		memberVO.setAttributes(oAuth2User.getAttributes());

		// 권한(Role)
		List<RoleVO> roleList = new ArrayList<>();
		RoleVO roleVO = new RoleVO();

		roleVO.setRoleName("ROLE_MEMBER"); // 멤버역할을 줌
		roleList.add(roleVO);

		memberVO.setRoleVOs(roleList);

		return memberVO;
	}
}

package com.iu.home.member;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService
{
	@Autowired
	private MemberMapper memberMapper;

	@Value("${kakao.Admin.key}")
	private String adminKey;

	public int setDelete(MemberVO memberVO) throws Exception
	{
		int rs = 0;
		// 카카오만 됨

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// header 넣기
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// MediaType.APPLICATION_FORM_URLENCODED: application/x-www-form-urlencoded
		headers.add("Authorization", "KakaoAK " + adminKey);

		// parameter 넣기
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("target_id_type", "user_id"); // user_id 고정
		param.add("target_id", memberVO.getId());

		// - 요청 객체
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(param, headers); // header param 순서 차이?

		// 전송 후 결과 처리
		// Response의 <> 안 : restTemplate의 형식과 동일하게
		ResponseEntity<String> res = restTemplate.postForEntity("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		// 링크, 결과 값, 형식

		// 아이디 찍히면 정상 탈퇴
		log.info("res: {}", res.getBody());
		
		if (res.getBody() != null)
		{
			rs = 1;
		}
		// 탈퇴되면 1 리턴 안되면 0 리턴
		return rs;
	}

	// 로그인 처리는 Security에서
	// public MemberVO getLogin(MemberVO memberVO) throws Exception
	// {
	// return memberMapper.getLogin(memberVO);
	// }

	public int setJoin(MemberVO memberVO) throws Exception
	{
		int rs = memberMapper.setJoin(memberVO);

		if (rs < 1)
		{
			throw new Exception();
		}

		rs = memberMapper.setMemberRole(memberVO);

		if (rs < 1)
		{
			throw new Exception();
		}

		return rs;
	}

	public int getCheckId(MemberVO memberVO) throws Exception
	{
		return memberMapper.getCheckId(memberVO);
	}

	// 사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception
	{
		boolean ch = false;
		// ch = false : 검증 성공 에러 없음
		// ch = true : 검증 실패 에러 있음

		// 1. Annotation 검증
		ch = bindingResult.hasErrors(); // 에러가 있으면 true 없으면 false
		// ch : true면 검증에 실패 false일 때 성공

		// 2. pwd 일치하는지 검증 - 비밀번호 일치 시 if문 안함
		if (!memberVO.getPwd().equals(memberVO.getPwCheck()))
		{
			ch = true;

			// 에러메세지
			// bindingResult.rejectValue("멤버변수(path)", "properties의 key(code)");
			bindingResult.rejectValue("pwCheck", "member.pwd.notEqual");
		}

		// 3. ID가 중복인지 검증
		int aa = memberMapper.getCheckId(memberVO);
		if (aa == 1)
		{
			ch = true;

			bindingResult.rejectValue("id", "member.id.exist");
		}

		return ch;
	}
}

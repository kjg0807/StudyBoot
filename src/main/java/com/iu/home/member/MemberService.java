package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
		if(aa == 1) {
			ch = true;
			
			bindingResult.rejectValue("id", "member.id.exist");
		}

		return ch;
	}
}

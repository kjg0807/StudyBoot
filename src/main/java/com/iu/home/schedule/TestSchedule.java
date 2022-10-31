package com.iu.home.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.home.member.MemberMapper;
import com.iu.home.member.MemberService;
import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedule
{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberMapper memberMapper;

	// cron = "* * * * * *" -> 1초마다 계속 실행
	// @Scheduled(cron = "30 * * * * *") // 6개의 단위 - 초, 분, 시, 일, 월, 요일
	public void cron() throws Exception
	{
		log.info("Cron 매초 실행");
		log.info(Calendar.getInstance().getTime().toString());
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoID" + Calendar.getInstance().getTimeInMillis());
		memberVO.setPwd("123");
		memberVO.setName("Name" + Calendar.getInstance().getTimeInMillis());
		memberVO.setEmail("Eamil" + Calendar.getInstance().getTimeInMillis());

		log.info("===== Result : {} =====", memberMapper.setJoin(memberVO));
	}

	// fixedRate - 일정한 간격으로 3000: 3초
	// @Scheduled(fixedRate = 3000, initialDelayString = "1000")
	public void ts1()
	{
		log.info("Scehedule 실행");
		try
		{
			Thread.sleep(4000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

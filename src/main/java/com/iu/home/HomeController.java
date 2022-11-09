package com.iu.home;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.iu.home.board.qna.PostVO;
import com.iu.home.board.qna.QnaMapper;
import com.iu.home.member.MemberVO;
import com.nimbusds.oauth2.sdk.Response;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController
{
	@Value("${my.message.hi}")
	private String message;

	@Value("${my.default}")
	private String app;

	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return "admin Role";
	}

	@GetMapping("/manager")
	@ResponseBody
	public String manager()
	{
		return "Manager Role";
	}

	@GetMapping("/user")
	@ResponseBody
	public String member()
	{
		return "Member Role";
	}

	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String client_id;

	@GetMapping("address")
	@ResponseBody
	public String address() throws Exception
	{
		// kakao 지도 요청
		RestTemplate restTemplate = new RestTemplate();

		// header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + client_id);
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("query", "전북 삼성동 100");

		// HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(headers);
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		ResponseEntity<String> res = restTemplate.getForEntity("https://dapi.kakao.com/v2/local/search/address.json", String.class, req);

		return res.getBody();
	}

	// final - 값 못 바꿈
	// private final org.slf4j.Logger log =
	// LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String home(HttpSession session) throws Exception
	{
		RestTemplate restTemplate = new RestTemplate();

		// 1. 헤더 정보
		HttpHeaders headers = new HttpHeaders();
		headers.add("key", "value");
		// headers.set헤더명("값");

		// 2. 파라미터
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("key", "value");

		// 3. 요청 정보 객체 - 1, 2번을 모음
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

		// 4. 전송 후 결과
		List<PostVO> postVOs = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class, request);
		// PostVO postVO = response.getBody();
		log.info("response: {}", postVOs);

		// ------------------------------------------------------------------------------------------------------------------------

		log.info("============================");
		// session.getAttributeNames() : String collection
		Enumeration<String> en = session.getAttributeNames();

		// Element가 있으면 true - boolean
		while (en.hasMoreElements())
		{
			String key = en.nextElement();
			log.info("KEY: {}", key);
		}
		// Impl : implements
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (context != null)
		{
			log.info("Context: {}", ((MemberVO) context.getAuthentication().getPrincipal()));
		}

		log.info("message: {}", message);
		log.info("default: {}", app);
		log.info("============================");

		return "index";
	}
}

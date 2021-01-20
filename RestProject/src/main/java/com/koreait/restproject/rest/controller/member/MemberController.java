package com.koreait.restproject.rest.controller.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController //Controller 에 ResponseBody가 탑재된 컨트롤러
@Slf4j
public class MemberController {
	
	@GetMapping("/member")
	public String getList() {
		log.debug("리스트 요청했어?");
		return "ha ha ha";
	}
}






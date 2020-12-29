package com.koreait.mvclegacy.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.mvclegacy.model.domain.Notice;
import com.koreait.mvclegacy.model.notice.NoticeService;

@Controller
public class NoticeController {
	private static final Logger logger=LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	//글쓰기 폼 요청 
	@RequestMapping("/notice/registform")
	public String getRegistForm() {
		return "notice/regist_form";
	}
	
	//글등록 요청 처리 
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public String regist(Notice notice){ //스프링에서는 vo의 멤버변수와  html의 파라미터명이 같으면
		//자동으로 데이터값이 vo에 채워진다.
		noticeService.insert(notice);
		return "redirect:/client/notice/list";
	}
	
	//모든 글 가져오기 요청 
	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public ModelAndView selectAll() {
		logger.debug("글목록 메서드 호출");
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", null);
		mav.setViewName("notice/list");
		return mav;
	}
}











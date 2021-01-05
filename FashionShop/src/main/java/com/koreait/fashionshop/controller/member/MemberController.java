package com.koreait.fashionshop.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.exception.MailSendException;
import com.koreait.fashionshop.exception.MemberRegistException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	//회원가입폼 요청 
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public String getRegistForm() {
		
		return "shop/member/signup";
	}
	
	//회원가입 요청 처리 
	@RequestMapping(value="/shop/member/regist", method=RequestMethod.POST)
	public String regist(Member member) {
		logger.debug("아이디 "+member.getUser_id());
		logger.debug("이름 "+member.getName());
		logger.debug("비번 "+member.getPassword());
		logger.debug("이메일id "+member.getEmail_id());
		logger.debug("이메일server "+member.getEmail_server());
		logger.debug("우편번호 "+member.getZipcode());
		logger.debug("주소 "+member.getAddr());
		
		memberService.regist(member);
		
		return "redirect:/";
	} 

	//예외 핸들러 2가지 처리
	@ExceptionHandler(MemberRegistException.class)
	public ModelAndView handleException(MemberRegistException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage()); //사용자가 보게될 에러 메시지
		mav.setViewName("shop/error/result");
		return mav;
	}
	
	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage()); //사용자가 보게될 에러 메시지
		mav.setViewName("shop/error/result");
		return mav;
	}
	
}













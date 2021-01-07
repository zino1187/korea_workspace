package com.koreait.fashionshop.controller.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.exception.MailSendException;
import com.koreait.fashionshop.exception.MemberRegistException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.member.service.MemberService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;

@Controller
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//회원가입폼 요청 
	@RequestMapping(value="/shop/member/registForm", method=RequestMethod.GET)
	public ModelAndView getRegistForm() {
		List topList = topCategoryService.selectAll();
		ModelAndView mav = new ModelAndView("shop/member/signup");
		mav.addObject("topList", topList); //담기
		return mav;
	}
	
	//회원가입 요청 처리 
	@RequestMapping(value="/shop/member/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String regist(Member member) {
		logger.debug("아이디 "+member.getUser_id());
		logger.debug("이름 "+member.getName());
		logger.debug("비번 "+member.getPassword());
		logger.debug("이메일id "+member.getEmail_id());
		logger.debug("이메일server "+member.getEmail_server());
		logger.debug("우편번호 "+member.getZipcode());
		logger.debug("주소 "+member.getAddr());
		
		memberService.regist(member);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"회원가입 성공\"");
		sb.append("}");
		
		return sb.toString();
	} 

	//로그인 홈 요청 
	@RequestMapping(value="/shop/member/loginForm", method=RequestMethod.GET)
	public ModelAndView getLoginForm() {
		List topList = topCategoryService.selectAll();
		ModelAndView mav = new ModelAndView("shop/member/signin");
		mav.addObject("topList", topList); //담기
		
		return mav;
	}
	
	//로그인 요청 처리
	@RequestMapping(value="/shop/member/login", method=RequestMethod.POST)
	public ModelAndView login(Member member) {
		//db에 존재여부 확인 
		
		//존재 O : 세션에 회원정보 담아두기 
		//존재 X : 예외로 처리..
		
		return null;
	}
	
	
	//예외 핸들러 2가지 처리
	@ExceptionHandler(MemberRegistException.class)
	@ResponseBody
	public String handleException(MemberRegistException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":0, ");
		sb.append(" \"msg\":\""+e.getMessage()+"\"");
		sb.append("}");
		
		return sb.toString();
	}
	
	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage()); //사용자가 보게될 에러 메시지
		mav.setViewName("shop/error/result");
		return mav;
	}
	
}













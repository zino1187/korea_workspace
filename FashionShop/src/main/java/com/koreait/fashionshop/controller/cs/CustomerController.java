package com.koreait.fashionshop.controller.cs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@GetMapping("/shop/cs/qna/list")
	public ModelAndView getMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("shop/cs/main");
		return mav;
	}
	
	@GetMapping("/shop/cs/qna/registForm")
	public ModelAndView getRegistForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("shop/cs/registForm");
		return mav;
	}
	
	@GetMapping("/shop/cs/qna/regist")
	public ModelAndView registQna(HttpServletRequest request) {
		
		
		ModelAndView mav = new ModelAndView("shop/cs/registForm");
		return mav;
	}
	
}

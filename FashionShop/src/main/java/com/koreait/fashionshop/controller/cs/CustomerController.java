package com.koreait.fashionshop.controller.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.common.Pager;
import com.koreait.fashionshop.model.qna.service.QnaService;

@Controller
public class CustomerController {
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private Pager pager;
	
	@GetMapping("/shop/cs/qna/list")
	public ModelAndView getMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("shop/cs/main");
		List qnaList = qnaService.selectAll();
		pager.init(request, qnaList); //넘겨진 List를 이용하여, 공식이 다시 계산됨..
		
		mav.addObject("pager", pager);
		
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

package com.koreait.fashionshop.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QnaController {
	@RequestMapping(value="/shop/cs/qna/list", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public String getQnaList(){
		System.out.println("qna lis called..");
		return "qna list ha ha ha ";
	}
}

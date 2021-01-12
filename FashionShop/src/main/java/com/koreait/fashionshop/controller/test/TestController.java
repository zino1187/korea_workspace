package com.koreait.fashionshop.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.fashionshop.model.common.Pager;

@Controller
public class TestController {
	@Autowired
	private Pager pager;
	
	@GetMapping("/test/test")
	@ResponseBody
	public String getList() {
		
		return "this is test : "+pager;
	}
}

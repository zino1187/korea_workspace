package com.koreait.fashionshop.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.fashionshop.model.common.Pager;

@Controller
public class ListController {
	@Autowired
	private Pager pager;
	
	@RequestMapping(value="/test/list", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getList() {
		
		return "this is list : "+pager;
	}
}

package com.study.springfinal.controller.gallery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springfinal.domain.Gallery;

@Controller
public class GalleryController{
	
	//스프링 프레임웍은 업로드 컴포넌트로, apache fileupload를 사용함		
	@RequestMapping(value="/gallery/regist", method=RequestMethod.POST)
	public String regist(Gallery gallery) {
		System.out.println("등록 원해?");
		System.out.println("title "+gallery.getTitle());
		System.out.println("writer "+gallery.getWriter());
		System.out.println("content "+gallery.getContent());
		System.out.println("photo "+gallery.getPhoto());

		return null;
	}
}

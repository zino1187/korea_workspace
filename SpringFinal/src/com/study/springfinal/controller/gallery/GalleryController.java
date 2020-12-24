package com.study.springfinal.controller.gallery;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.study.springfinal.common.FileManager;
import com.study.springfinal.domain.Gallery;
import com.study.springfinal.model.dao.GalleryDAO;

@Controller
public class GalleryController{
	//표시를 할테니, 여기에 넣어주세요!!
	@Autowired
	private GalleryDAO galleryDAO;
		
	//스프링 프레임웍은 업로드 컴포넌트로, apache fileupload를 사용함		
	@RequestMapping(value="/gallery/regist", method=RequestMethod.POST)
	public String regist(Gallery gallery, HttpServletRequest request) {
		
		//물리적 저장
		MultipartFile photo=gallery.getPhoto();
		System.out.println("original is "+photo.getOriginalFilename());
		System.out.println("getName is "+photo.getName());
		System.out.println("size is "+photo.getSize());
		System.out.println("contentType is "+photo.getContentType());
		
		//파일명 새로 만들어, 저장하기 
		String newName = Long.toString(System.currentTimeMillis());
		String ext = FileManager.getExtend(photo.getOriginalFilename());
		String filename=newName+"."+ext; //최종 파일명..
		gallery.setFilename(filename); //새로운 파일명 VO에 저장
		ServletContext context=request.getServletContext();
		String realPath = context.getRealPath("/data");
		//이클립스 내부 톰켓인 경우, 실제 경로와는 틀린 경로에 저장..개발시엔 그 경로를 확인하려면
		//출력 
		System.out.println(realPath);
		
		try {
			photo.transferTo(new File(realPath+"/"+filename)); //물리적 저장!!!
			
			int result = galleryDAO.insert(gallery);
			
			System.out.println("등록결과는 "+result);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}




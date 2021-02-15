package com.koreait.bootgradle.model.photo.repository;

import org.springframework.stereotype.Repository;

import com.koreait.bootgradle.exception.PhotoUpdateException;
import com.koreait.bootgradle.model.domain.Photo;

@Repository
public class MybatisPhotoDAO implements PhotoDAO{
	
	//mybatis 설정..
	public void insert(Photo photo) throws PhotoUpdateException{
		
	}
}

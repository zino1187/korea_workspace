package com.koreait.bootgradle.model.service.photo;

import org.springframework.stereotype.Service;

import com.koreait.bootgradle.model.domain.Photo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService{

	public void regist(Photo photo) {
		log.debug("regist() 호출");
	}
}

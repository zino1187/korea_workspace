package com.study.springfinal.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springfinal.domain.Gallery;
import com.study.springfinal.mybatis.config.MybatisConfigManager;

@Repository
public class GalleryDAO {
	@Autowired
	private MybatisConfigManager manager;

	
	public int insert(Gallery gallery) {
		int result = 0;
		SqlSession sqlSession  = manager.getSqlSession();
		result = sqlSession.insert("Gallery.insert", gallery);
		sqlSession.commit();
		manager.close(sqlSession);
		return result;
	}
}














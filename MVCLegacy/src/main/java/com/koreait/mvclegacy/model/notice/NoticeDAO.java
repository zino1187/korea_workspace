package com.koreait.mvclegacy.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mvclegacy.model.domain.Notice;

@Repository
public class NoticeDAO {
	//스프링이 지원하는 DB기술을 이용하기전에는, 트랜잭션 때문에 SqlSession을 서비스로부터
	//주입받았으나, 더이상 트랜잭션 때문에 서비스가에서 주입받을 필요없다..스프링이 알아서 트랜잭션을
	//처리해준다..
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	public List selectAll() {
		List list = null;
		list=sessionTemplate.selectList("Notice.selectAll");
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice = null;
		return notice;
	}
	public void insert(Notice notice) {
		
	}
	public void update(Notice notice) {
		
	}
	public void delete(int notice_id) {
		
	}
	
}









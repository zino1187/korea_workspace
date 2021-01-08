package com.koreait.fashionshop.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.common.Bell;

@Repository
public class JdbcSbankDAO implements SbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Bell bell;
	
	//입금
	public void deposit(int money) {
		bell.sound();
		jdbcTemplate.update("insert into sbank(sbank_id, total) values(seq_sbank.nextval,?)", money);
	}
	
}

package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DbInsUpdRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertOrder(String item_id,String price) {
		jdbcTemplate.update("INSERT INTO spitem_order (item_id,baika) VALUES (?,?)", item_id,price);
	}
	
}

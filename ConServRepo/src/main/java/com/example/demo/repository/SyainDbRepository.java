package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SyainDbRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//社員全件検索
	public List<Map<String,Object>> findAll(){
		return jdbcTemplate.queryForList("SELECT * FROM syain");
	}
	
	//社員登録
	public void insertSyain(String id, String name, String email) {
		jdbcTemplate.update("INSERT INTO syain (id,name,email) VALUES (?,?,?)", id, name, email);
	}
	
	//社員削除(ID指定)
	public void delSyain(String id) {
		jdbcTemplate.update("DELETE FROM syain WHERE id = ?", id);
	}
	
	//社員全件削除
	public void delSyainAll() {
		jdbcTemplate.update("DELETE FROM syain");
	}
}

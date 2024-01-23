package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DbSearchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//spitem全件検索メソッド
	public List<Map<String, Object>> findAll() {
		return jdbcTemplate.queryForList("SELECT * FROM spitem");
	}

	//【チュートリアル用】
	//spitem_orderテーブル全件検索メソッド
		

	//【練習問題用】
	//カテゴリ別検。
	//コメント外して使ってね。
	//	public List<Map<String, Object>> ????(String category) {
	//		return jdbcTemplate.queryForList("SELECT * FROM spitem");
	//	}

}

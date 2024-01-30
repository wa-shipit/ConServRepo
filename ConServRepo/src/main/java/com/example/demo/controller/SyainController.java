package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.SyainDbRepository;

@Controller
public class SyainController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SyainDbRepository syainDbRepository;
	
	//画面表示用メソッド
	@RequestMapping(path = "/syain", method = RequestMethod.GET)
	public String first(Model model) {

		//社員テーブルの全件検索
		List<Map<String, Object>> resultList = syainDbRepository.findAll();
		
		model.addAttribute("resultList", resultList);

		return "syain";
	}
	
	//社員登録用メソッド
	@RequestMapping(path = "/syain/add", method = RequestMethod.POST)
	public String second(Model model,String id, String name, String email) {
		
		//社員テーブルにINSERT文を発行するRepositoryの呼び出し。
		syainDbRepository.insertSyain(id, name, email);
		
		return "redirect:/syain";
	}
	
	//社員削除用メソッド(ID指定)
	@RequestMapping(path = "/syain/delete", method = RequestMethod.POST)
	public String third(Model model,String id) {
		
		//社員テーブルにDELETE文を発行するRepositoryの呼び出し。
		syainDbRepository.delSyain(id);	
		
		return "redirect:/syain";
	}
	
	//社員全件削除メソッド
	@RequestMapping(path = "/syain/deleteall", method = RequestMethod.GET)
	public String third(Model model) {
		
		//社員テーブルにDELETE文を発行するRepositoryの呼び出し。
		syainDbRepository.delSyainAll();	
		
		return "redirect:/syain";
	}
}

package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BunriMatomeController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//画面表示用
	@RequestMapping(path = "/bunrimatome", method = RequestMethod.GET)
	public String bunriMatome(Model model) {

		//練習問題①
		//以下のプログラムをServiceクラスに分離しよう
		String[] item = { "商品A", "商品B", "商品C", "商品D", "商品E" };
		int a = (int) (Math.random() * 5);
		System.out.println(item[a]);
		
		//練習問題②
		//以下のSELECT部分をRepositoryクラスに分離しよう
		List<Map<String,Object>> result= jdbcTemplate.queryForList("SELECT * FROM spitem");
		model.addAttribute("resultList", result);
		
		//練習問題③
		//以下のSELECT部分をRepositoryクラスに分離しよう
		List<Map<String,Object>> orderResult= jdbcTemplate.queryForList("SELECT * FROM spitem_order");
		model.addAttribute("orderResult", orderResult);
		
		return "bunriMatome";
	}
	
	//入力フォーム処理用
	@RequestMapping(path = "/bunrimatome", method = RequestMethod.POST)
	public String bunriMatomePost(Model model, String mode, String item_id, String price) {

		
		if ("delete".equals(mode) && mode != null) {
			//練習問題④
			//以下のプログラムをRepositoryクラスに分離しよう
			jdbcTemplate.update("DELETE FROM spitem_order");
			
		} else if(item_id != null && price != null) {
			//練習問題⑤以下のプログラムをRepositoryクラスに分離しよう
			jdbcTemplate.update("INSERT INTO spitem_order (item_id,baika) VALUES (?,?)", item_id,price);
		} else {
			System.out.println("DB処理無し");
		}
		 
		return "redirect:/bunrimatome";
	}
	
	
	//応用問題//
	//次回の授業範囲ではありますが、Repositoryクラスに分離したSQLを排除しましょう。
	//EntityとインタフェースのRepositoryを使う事で実現できます。
	//EntityとRepositoryインタフェースについては、Slackに資料を流しますので、
	//それを参考に頑張ってみてください！！
	//(これ出来ちゃったら次回どうしようかね)
}

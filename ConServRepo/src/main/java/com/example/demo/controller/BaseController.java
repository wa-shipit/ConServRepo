package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.DbSearchRepository;


@Controller
public class BaseController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DbSearchRepository dbSearchRepository;
	
	
	//画面表示に利用
	@RequestMapping(path = "/items", method = RequestMethod.GET)
	public String first(Model model) {

		//【復習問題用ビジネスロジック】
		//int型変数「a」に0～99までのランダムな数値を格納する。
		//その後「a」の値が50未満なら「小さい」それ以上なら「大きい」をSysoutするプログラム
		
		/*********************************************
		 * 【分離済み】DBに接続しSELECT文を発行する。
		 **********************************************/
		
		List<Map<String, Object>> resultList = dbSearchRepository.findAll();
		model.addAttribute("resultList", resultList);
		
		/*********************************************/
		
		
		/*********************************************
		 * 【分離チュートリアル】DBに接続しSELECT文を発行する。
		 * 注文履歴テーブルへの検索処理を一緒に移植していこう。
		 **********************************************/
		List<Map<String, Object>> orderList = jdbcTemplate.queryForList("SELECT * FROM spitem_order");
		model.addAttribute("orderList", orderList);
		
		/**********************************************/

		//htmlの表示
		return "items";
	}

	//検索時に利用
	@RequestMapping(path = "/items/{category}", method = RequestMethod.GET)
	public String second(@PathVariable String category,Model model) {

		/*********************************************
		 * 【分離練習問題①】
		 * 以下のDB処理をDbSearchRepositoryに移植しよう。尚、移植時のメソッド名は「findByCategory」とする事。
		 **********************************************/
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT * FROM spitem WHERE category = ?",
				category);

		model.addAttribute("resultList", resultList);

		return "items";
	}
	
	//注文処理用
	@RequestMapping(path = "/items/{item_id}/{price}", method = RequestMethod.GET)
	public String third(@PathVariable String item_id,@PathVariable String price){


		/*********************************************
		 * 【分離練習問題②】
		 * 以下のDB処理をDbInsUpdRepositoryに移植しよう。尚、移植時のメソッド名は「insertOrder」とする事。
		 **********************************************/
		jdbcTemplate.update("INSERT INTO spitem_order (item_id,baika) VALUES (?,?)", item_id,price);

		return "redirect:/items";
	}
	
	//削除用
	@RequestMapping(path = "/items/orderdel", method = RequestMethod.GET)
	public String fourth(){


		/*********************************************
		 * 【分離練習問題③】
		 * 新しくリポジトリクラスを作成し、以下の削除処理を分離しよう。
		 * 尚、クラス名は「DbDelRepository」とし、メソッド名は「deleteOrder」とする事。
		 **********************************************/
		jdbcTemplate.update("DELETE FROM spitem_order");

		return "redirect:/items";
	}
	
	
	//応用問題用
	@RequestMapping(path = "/items/group", method = RequestMethod.GET)
	public String five(){

		//以下の仕様を満たすメソッドを作成しなさい。
		//①カテゴリ別の売上"件数"を求める。
		//②件数集計はSQLでやってもJavaでやってもOK
		//③集計対象のテーブルはspitem_order
		//④ControllerにSQLを書いてはいけない。
        //⑤集計結果はSys表示する事。例：飲食品売上件数：〇件


		return "redirect:/items";
	}
	
	
}

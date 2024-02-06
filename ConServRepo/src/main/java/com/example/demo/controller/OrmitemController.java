package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrmitemController {

	/**
	 * 練習問題用
	 * コメントの通りのプログラムにしてください。
	 * SQL禁止。
	 */
	
	//画面表示用メソッド
	@RequestMapping(path = "/ormitem", method = RequestMethod.GET)
	public String first(Model model) {

		//商品テーブルの全件検索
		//検索結果をmodelに格納.格納する際の名前は「resultList」とする。
		
		return "ormitem";
	}
	
	//商品検索用メソッド
	@RequestMapping(path = "/ormitem/search", method = RequestMethod.POST)
		public String firstPost(Model model,String itemname) {
		
			//画面から入力された商品名であいまい検索をする。
			//ヒントRepositoryにメソッドを独自定義する必要あり。
		
			
			//検索結果をmodelに格納する。
			
		return "ormitem";
	}
	
	//商品登録用メソッド
	@RequestMapping(path = "/ormitem/add", method = RequestMethod.POST)
	public String second(String itemid, String itemname, String itembaika,String itemgenka) {
		
		//必要があればStrignで受け取った変数int型に変換する。必要かどうかはEntityを見てね。
		
		//商品テーブルにINSERT文を発行するメソッド「save」の呼び出し。
		
		return "redirect:/ormitem";
	}
	
	//商品削除用メソッド(ID指定)
	@RequestMapping(path = "/ormitem/delete", method = RequestMethod.POST)
	public String third(Model model,String itemid) {
		
		//商品テーブルにDELETE文を発行するメソッド「deleteById」の呼び出し。
		
		return "redirect:/ormitem";
	}
	
	/***
	 * 応用問題①
	 * 画面から入力された下限金額と上限金額の範囲内の商品を検索
	 * 尚、売価で検索する。
	 * 
	 */
	@RequestMapping(path = "/ormitem/search/ouyou", method = RequestMethod.POST)
	public String fourth(Model model) {
		
		
		return "redirect:/ormitem";
	}
	
	/***
	 * 応用問題②
	 * 全件削除
	 */
//	@RequestMapping(path = "/ormitem/delAll", method = RequestMethod.???)
//	public String fifth() {
//		//JpaRepositoryが標準で持つ全件削除メソッドを呼び出す。
//		//メソッド名は調べてみてね～～～
	
//		return "redirect:/ormitem";
//	}
	
}

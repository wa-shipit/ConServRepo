package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

	/**
	 * 練習問題用
	 * コメントの通りのプログラムにしてください。
	 * SQL禁止。
	 */
	
	//画面表示用メソッド
	@RequestMapping(path = "/company", method = RequestMethod.GET)
	public String first(Model model) {

		//会社テーブルの全件検索
		//検索結果をmodelに格納.格納する際の名前は「resultList」とする。

		return "company";
	}
	
	//会社検索用メソッド
	@RequestMapping(path = "/company/search", method = RequestMethod.POST)
		public String firstPost(Model model,String compname) {
		
			//画面から入力された会社名であいまい検索をする。
			//ヒントRepositoryにメソッドを独自定義する必要あり。
		
			
			//検索結果をmodelに格納する。
			
		return "redirect:/company";
	}
	
	//会社登録用メソッド
	@RequestMapping(path = "/company/add", method = RequestMethod.POST)
	public String second(String compid, String compname, String compmember,String compboss) {
		
		//compidとcompmemberはint型にする。
		
		//会社テーブルにINSERT文を発行するメソッド「save」の呼び出し。
		
		return "redirect:/company";
	}
	
	//会社削除用メソッド(ID指定)
	@RequestMapping(path = "/company/delete", method = RequestMethod.POST)
	public String third(Model model,String compid) {
		
		//会社テーブルにDELETE文を発行するメソッド「deleteAll」の呼び出し。
		
		return "redirect:/company";
	}
	
	/***
	 * 応用問題
	 * 会社名と代表者名でOR検索し、検索結果をmodelに格納し、/companyにリダイレクトする。
	 * 
	 */
	@RequestMapping(path = "/company/search/ouyou", method = RequestMethod.POST)
	public String fourth(Model model) {
		
		
		return "redirect:/company";
	}
	
	/***
	 * 挑戦問題
	 * このプログラムの中で、1か所Serviceに分離できる部分がある。
	 * その部分を分離するためのServiceクラスを作成し、分離してください。
	 * 
	 */

		
}

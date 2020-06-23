package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.service.HotelService;

/**
 * ホテルに関する操作を管理するコントローラーです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Controller
@RequestMapping("/Ex02")
public class HotelController {
	@Autowired
	private HotelService service;
	
	/**
	 * トップページを表示するメソッドです.
	 * 
	 * @param model
	 * 				初期状態を表示するためのリクエストスコープです。<br>
	 * 				ホテルのリストが空の状態で渡されます。
	 * @return
	 * 				検索画面へフォワードします。
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Hotel> hotelList = new ArrayList<>();
		
		model.addAttribute("hotelList", hotelList);
		
		return "search";
	}
	
	/**
	 * 「検索」ボタンが押された際に呼び出されるメソッドです.<br>
	 * 価格が入力されていた場合は価格以下のホテルを、<br>
	 * 入力されていない場合は全権検索を行います。
	 * 
	 * @param price
	 * 				検索したい価格
	 * @param model
	 * 				検索結果をフォワード先へ渡すためのリクエストスコープです。
	 * @return
	 * 				検索画面へフォワードします。
	 */
	@RequestMapping("/search")
	public String search(Integer price, Model model) {
		if (price == null) {
			model.addAttribute("hotelList", service.findAll());
		} else {
			model.addAttribute("hotelList", service.searchPrice(price));
		}
		
		return "search";
	}

}

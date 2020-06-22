package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Team;
import jp.co.rakus.service.Ex1Service;

/**
 * チームを表示するためのコントローラーです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Controller
@RequestMapping("/Ex01")
public class Ex1Controller {
	@Autowired
	private Ex1Service service;
	
	/**
	 * チーム一覧を表示するためのメソッドです.
	 * 
	 * @param model
	 * 				チーム一覧をリスト形式で格納するためのリクエストスコープです。
	 * @return
	 * 				チーム一覧を表示するページへフォワードします。
	 */
	@RequestMapping("/teamList")
	public String teamList(Model model) {
		List<Team> teamList = service.findAll();
		
		model.addAttribute("teamList", teamList);
		
		return "teamList";
	}
	
	/**
	 * チームの詳細を表示するためのメソッドです.
	 * 
	 * @param id
	 * 				詳細を表示したいチームのidを受け取ります。
	 * @param model
	 * 				詳細を表示したいチームの主キー検索結果を格納するリクエストスコープです。
	 * @return
	 * 				主キー検索結果が不正: 不正操作を知らせる画面へフォワードします。<br>
	 * 				主キー検索結果が正常: チームの詳細を表示する画面へフォワードします。
	 */
	@RequestMapping("/teamDetail")
	public String teamDetail(Integer id, Model model) {
		Team team = service.load(id);
		if(team.getId() == null) {
			return "error1";
		}
		
		model.addAttribute("team", team);
		
		return "teamDetail";
	}
}

package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Team;
import jp.co.rakus.service.Ex1Service;

@Controller
@RequestMapping("/Ex01")
public class Ex1Controller {
	@Autowired
	private Ex1Service service;
	
	@RequestMapping("")
	public String index() {
		return "teamList";
	}
	
	
	@RequestMapping("/teamList")
	public String teamList(Model model) {
		List<Team> teamList = service.findAll();
		
		model.addAttribute("teamList", teamList);
		
		return "teamList";
	}
}

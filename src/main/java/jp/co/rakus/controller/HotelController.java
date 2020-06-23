package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.service.HotelService;

@Controller
@RequestMapping("/Ex02")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Hotel> hotelList = new ArrayList<>();
		
		model.addAttribute("hotelList", hotelList);
		
		return "search";
	}
	
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

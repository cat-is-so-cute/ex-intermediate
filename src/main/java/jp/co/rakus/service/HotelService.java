package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> searchPrice(int price) {
		return repository.searchPrice(price);
	}
	
	public List<Hotel> findAll (){
		return repository.findAll();
	}
}

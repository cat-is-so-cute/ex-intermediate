package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.repository.HotelRepository;

/**
 * ホテルの情報を扱うサービスクラスです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	/**
	 * 与えられた価格以下のホテルを検索するメソッドです.
	 * 
	 * @param price
	 * 				価格
	 * 
	 * @return
	 * 				与えられた価格以下のホテルをリスト形式で返します。
	 */
	public List<Hotel> searchPrice(int price) {
		return repository.searchPrice(price);
	}
	
	/**
	 * ホテルの全権検索を行うメソッドです.
	 * 
	 * @return
	 * 				ホテルの全権検索結果をリスト形式で返します。
	 */
	public List<Hotel> findAll (){
		return repository.findAll();
	}
}

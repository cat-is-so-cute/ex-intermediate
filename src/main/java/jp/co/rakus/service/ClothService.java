package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Cloth;
import jp.co.rakus.repository.ClothRepository;

/**
 * 衣類情報を扱うサービスクラスです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository repository;
	
	/**
	 * 与えられた色と性別に一致する衣類を検索するメソッドです.
	 * 
	 * @param color
	 * 					色
	 * @param gender
	 * 					性別(0:男性, 1:女性)
	 * @return
	 * 					条件に一致する衣類がリスト形式で帰ります。
	 */
	public List<Cloth> searchByColorAndGender(String color, Integer gender){
		return repository.searchByColorAndGender(color, gender);
	}
}

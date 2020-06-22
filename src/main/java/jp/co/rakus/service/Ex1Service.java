package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Team;
import jp.co.rakus.repository.Ex1Repository;

/**
 * チームを操作するためのサービスクラスです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Service
@Transactional
public class Ex1Service {
	@Autowired
	private Ex1Repository repository;
	
	/**
	 * レポジトリを呼び出し主キー検索を行います.
	 * 
	 * @param id
	 * 			検索したいチームのid
	 * 
	 * @return
	 * 			検索されたチームを返します(該当するものがない場合idがnullとなります)。
	 */
	public Team load(int id) {
		return repository.load(id);
	}
	
	/**
	 * レポジトリを呼び出し全件検索を行います.
	 * 
	 * @return
	 * 			チームの全件をリスト形式で返します。
	 */
	public List<Team> findAll() {
		return repository.findAll();
	}
}

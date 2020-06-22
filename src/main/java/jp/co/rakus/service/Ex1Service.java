package jp.co.rakus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Team;
import jp.co.rakus.repository.Ex1Repository;

@Service
@Transactional
public class Ex1Service {
	@Autowired
	private Ex1Repository repository;
	
	public Team load(int id) {
		return repository.load(id);
	}
	
	public List<Team> findAll() {
		return repository.findAll();
	}
}

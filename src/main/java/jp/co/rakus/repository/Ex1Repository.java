package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Team;

/**
 * チームのDBを操作するためのリポジトリです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Repository
public class Ex1Repository {
	/**
	 * チームのRowMapperを定義します.<br>
	 * 歴史の文字列は"\n"で分割され、リストとして格納されます。
	 * 
	 * @return チームのRowMapperを返します。
	 */
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		
		return team;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * チームの主キー検索を行います.
	 * 
	 * @param id
	 * 			検索するID
	 * 
	 * @return
	 * 			検索されたチームを返します(該当するものがない場合idがnullとなります)。
	 */
	public Team load(int id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id;";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("id", id);
		
		return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
	}
	
	/**
	 * チームの全件検索を行います.
	 * 
	 * @return
	 * 			チームの全件をリスト形式で返します。
	 */
	public List<Team> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";
		
		return template.query(sql, TEAM_ROW_MAPPER);
	}
}

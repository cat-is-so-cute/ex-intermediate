package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Cloth;

/**
 * 衣類情報を扱うためのレポジトリです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Repository
public class ClothRepository {
	/**
	 * 衣類のRowMapperを定義します.
	 * 
	 */
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
		Cloth cloth = new Cloth();
		
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		
		return cloth;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
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
	public List<Cloth> searchByColorAndGender(String color, Integer gender) {
		String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE color=:color AND gender=:gender;";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("color", color).addValue("gender", gender);
		
		return template.query(sql, param, CLOTH_ROW_MAPPER);
	}

}

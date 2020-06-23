package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Hotel;

/**
 * ホテルの情報を扱うためのレポジトリです.
 * 
 * @author ryosuke.nakanishi
 *
 */
@Repository
public class HotelRepository {
	/**
	 * ホテルのRowMapperを定義します.
	 * 
	 */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		
		return hotel;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 与えられた価格以下のホテルを検索するメソッドです.
	 * 
	 * @param price
	 * 				価格
	 * @return
	 * 				与えられた価格以下のホテルをリスト形式で返します。
	 */
	public List<Hotel> searchPrice(int price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ORDER BY price DESC;";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("price", price);
		
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
	
	/**
	 * ホテルの全権検索を行うメソッドです
	 * 
	 * @return
	 * 				ホテルの全権検索結果をリスト形式で返します。
	 * 
	 */
	public List<Hotel> findAll(){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC;";
		
		return template.query(sql, HOTEL_ROW_MAPPER);
	}
	
}

package tr.com.obss.dao.favorite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.favorite.FavoriteDao;
import tr.com.obss.model.Favorite;
@Repository
public class FavoriteDaoImpl implements FavoriteDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Favorite post(Favorite favorite) {
		String sql = "INSERT INTO favorite "
				+ "(userID,bookID) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] {favorite.getUserID(),favorite.getBookID()});
		System.out.println("Insert Book to Favorite!!!");
		return favorite;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Favorite get(int userID) {
		String sql = "SELECT * FROM favorite WHERE userID = ?";
		Favorite favorite = (Favorite) jdbcTemplate.queryForObject(sql, new Object[] { userID }, new BeanPropertyRowMapper(Favorite.class));
		System.out.println(favorite);
		return favorite;
	}

	@Override
	public Favorite put(int userID, Favorite favorite) {
		String sql = "UPDATE favorite SET userID=?,bookID=? WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] {favorite.getUserID(),favorite.getBookID(),userID});
		System.out.println("Favorite Updated!!!");
		return favorite;
	}

	@Override
	public void delete(int bookID) {
		String sql = "DELETE FROM favorite WHERE bookID=?";
		jdbcTemplate.update(sql, new Object[] { bookID });
		System.out.println("Favorite Deleted!!!");
	}

}

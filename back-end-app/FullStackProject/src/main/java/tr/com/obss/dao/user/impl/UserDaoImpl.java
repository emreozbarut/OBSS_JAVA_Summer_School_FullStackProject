package tr.com.obss.dao.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.user.UserDao;
import tr.com.obss.dao.user.mapper.UserRowMapper;
import tr.com.obss.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User post(User user) {

		String sql = "INSERT INTO user " + "(userID, roleID, username, email, password) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { user.getUserID(), user.getRoleID(), user.getUsername(), user.getEmail(),
				user.getPassword() });
		System.out.println("Insert User!!!");
		return user;
	}

	@SuppressWarnings("unchecked")
	public User get(int userID) {

		String sql = "SELECT * FROM user WHERE userID = ?";
		User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { userID }, new UserRowMapper());
		System.out.println(user);
		return user;

	}

	@Override
	public User put(int userID, User user) {
		String sql = "UPDATE user SET userID=?,roleID=?,username=?,email=?,password=? WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { user.getUserID(), user.getRoleID(), user.getUsername(), user.getEmail(),
				user.getPassword(), userID });
		System.out.println("Updated!!!");
		return user;
	}

	@Override
	public void delete(int userID) {
		String sql = "DELETE FROM user WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { userID });
		System.out.println("Deleted!!!");
	}

}

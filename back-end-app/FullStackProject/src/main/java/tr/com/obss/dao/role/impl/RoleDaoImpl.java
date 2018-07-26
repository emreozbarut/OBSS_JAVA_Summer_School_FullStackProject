package tr.com.obss.dao.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.role.RoleDao;
import tr.com.obss.model.Role;
@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Role post(Role role) {
		String sql = "INSERT INTO role "
				+ "(userID,roleName) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] {role.getUserID(),role.getRoleName()});
		System.out.println(role.getUserID()+" Inserted to "+role.getRoleName());
		return role;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Role get(int userID) {
		String sql = "SELECT * FROM role WHERE userID = ?";
		Role role = (Role) jdbcTemplate.queryForObject(sql, new Object[] { userID }, new BeanPropertyRowMapper(Role.class));
		System.out.println(role);
		return role;
	}

	@Override
	public Role put(int userID, Role role) {
		String sql = "UPDATE role SET userID=?,roleName=? WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] {role.getUserID(),role.getRoleName(),userID});
		System.out.println(role.getUserID()+" Role Updated to"+role.getRoleName());
		return role;
	}

	@Override
	public void delete(int userID) {
		String sql = "DELETE FROM role WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { userID });
		System.out.println(userID+"'s Role Deleted!!!");
	}

}

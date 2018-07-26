package tr.com.obss.dao.record.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.record.RecordDao;
import tr.com.obss.model.Record;
@Repository
public class RecordDaoImpl implements RecordDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Record post(Record record) {
		String sql = "INSERT INTO record "
				+ "(userID,bookID) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] {record.getUserID(),record.getBookID()});
		System.out.println(record.getUserID()+" Insert Book to Record!!!");
		return record;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Record get(int userID) {
		String sql = "SELECT * FROM record WHERE userID = ?";
		Record record = (Record) jdbcTemplate.queryForObject(sql, new Object[] { userID }, new BeanPropertyRowMapper(Record.class));
		System.out.println(record);
		return record;
	}
	@Override
	public Record put(int userID, Record record) {
		String sql = "UPDATE record SET userID=?,bookID=? WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] {record.getUserID(),record.getBookID(),userID});
		System.out.println("Record Updated!!!");
		return record;
	}
	@Override
	public void delete(int userID) {
		String sql = "DELETE FROM record WHERE userID=?";
		jdbcTemplate.update(sql, new Object[] { userID });
		System.out.println("Record Deleted!!!");
	}
	
}

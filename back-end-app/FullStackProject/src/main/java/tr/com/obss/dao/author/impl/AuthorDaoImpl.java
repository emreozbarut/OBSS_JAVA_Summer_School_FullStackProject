package tr.com.obss.dao.author.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.author.AuthorDao;
import tr.com.obss.dao.author.mapper.AuthorMapper;
import tr.com.obss.model.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Author post(Author author) {
		String sql = "INSERT INTO author " + "(authorID, name, surname) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { author.getAuthorID(),author.getName(), author.getSurname()});
		System.out.println("Insert author!!!");
		return author;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public Author get(int authorID) {
		String sql = "SELECT * FROM author WHERE authorID = ?";
		Author author = (Author) jdbcTemplate.queryForObject(sql, new Object[] { authorID },new AuthorMapper());
		System.out.println(author);
		return author;
	}

	@Override
	public Author put(int authorID, Author author) {
		String sql = "UPDATE author SET authorID=?,name=?,surname=? WHERE authorID=?";
		jdbcTemplate.update(sql,new Object[] { author.getAuthorID(), author.getName(), author.getSurname(), authorID });
		System.out.println("Author Updated!!!");
		return author;
	}

	@Override
	public void delete(int authorID) {
		String sql = "DELETE FROM author WHERE authorID=?";
		jdbcTemplate.update(sql, new Object[] { authorID });
		System.out.println("Author Deleted!!!");
	}

}

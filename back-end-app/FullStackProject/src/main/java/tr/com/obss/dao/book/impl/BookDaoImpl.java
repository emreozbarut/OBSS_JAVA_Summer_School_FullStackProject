package tr.com.obss.dao.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.book.BookDao;
import tr.com.obss.model.Book;
@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Book post(Book book) {
		String sql = "INSERT INTO book "
				+ "(bookID,authorID) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] {book.getBookID(),book.getAuthorID()});
		System.out.println("Insert Book!!!");
		return book;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Book get(int bookID) {
		String sql = "SELECT * FROM book WHERE bookID = ?";
		Book book = (Book) jdbcTemplate.queryForObject(sql, new Object[] { bookID }, new BeanPropertyRowMapper(Book.class));
		System.out.println(book);
		return book;
	}

	@Override
	public Book put(int bookID, Book book) {
		String sql = "UPDATE book SET bookID=?,authorID=? WHERE bookID=?";
		jdbcTemplate.update(sql, new Object[] {book.getBookID(),book.getAuthorID(),bookID});
		System.out.println("Book Updated!!!");
		return book;
	}

	@Override
	public void delete(int bookID) {
		String sql = "DELETE FROM book WHERE bookID=?";
		jdbcTemplate.update(sql, new Object[] { bookID });
		System.out.println("Book Deleted!!!");
	}

}

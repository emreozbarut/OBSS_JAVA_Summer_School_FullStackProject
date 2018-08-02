package tr.com.obss.dao.bookinfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.com.obss.dao.bookinfo.BookInfoDao;
import tr.com.obss.model.BookInfo;

@Repository
public class BookInfoDaoImpl implements BookInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public BookInfo post(BookInfo book) {
		String sql = "INSERT INTO bookinfo "
				+ "(bookID, title, publishDate, updateDate, insertDate, insertedBy) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {book.getBookID(),book.getTitle(),book.getPublishDate(),book.getUpdateDate(),book.getInsertDate(),book.getInsertedBy()});
		System.out.println("Insert Book!!!");
		return book;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BookInfo get(int bookID) {
		String sql = "SELECT * FROM bookinfo WHERE bookID = ?";
		BookInfo book = (BookInfo) jdbcTemplate.queryForObject(sql, new Object[] { bookID }, new BeanPropertyRowMapper(BookInfo.class));
		System.out.println(book);
		return book;
	}

	@Override
	public BookInfo put(int bookID, BookInfo book) {
		String sql = "UPDATE bookinfo SET bookID=?,title=?,publishDate=?,updateDate=?,insertDate=?,insertedBy=?  WHERE bookID=?";
		jdbcTemplate.update(sql, new Object[] {book.getBookID(),book.getTitle(),book.getPublishDate(),book.getUpdateDate(),book.getInsertDate(),book.getInsertedBy(),bookID});
		System.out.println("Book Updated!!!");
		return book;
	}

	@Override
	public void delete(String title) {
		String sql = "DELETE FROM bookinfo WHERE title=?";
		jdbcTemplate.update(sql, new Object[] { title });
		System.out.println("Book Deleted!!!");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BookInfo> getAll() {
		String sql = "SELECT * FROM bookinfo";
		List<BookInfo> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BookInfo.class));	
		System.out.println("getAll Called!!!");
		return books;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BookInfo> getBookByTitle(String title) {
		String sql = "SELECT * FROM bookinfo WHERE title LIKE '%"+title+"%'";//SQL injection !!!
		List<BookInfo> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BookInfo.class));
		System.out.println("getBookByTitle!!!");
		return books;
	}

}

package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.book.BookDao;
import tr.com.obss.model.Book;
import tr.com.obss.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book post(Book book) {
		return bookDao.post(book);
	}

	@Override
	public Book get(int bookID) {
		return bookDao.get(bookID);
	}

	@Override
	public Book put(int bookID, Book book) {
		return bookDao.put(bookID, book);
	}

	@Override
	public void delete(int bookID) {
		bookDao.delete(bookID);
	}

}

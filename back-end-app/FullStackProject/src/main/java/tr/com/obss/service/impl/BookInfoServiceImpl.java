package tr.com.obss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.bookinfo.BookInfoDao;
import tr.com.obss.model.BookInfo;
import tr.com.obss.service.BookInfoService;

@Service
public class BookInfoServiceImpl implements BookInfoService {
	@Autowired
	private BookInfoDao bookDao;

	@Override
	public BookInfo get(int bookID) {
		return bookDao.get(bookID);
	}

	@Override
	public BookInfo post(BookInfo book) {
		return bookDao.post(book);
	}

	@Override
	public BookInfo put(int bookID, BookInfo book) {
		return bookDao.put(bookID, book);
	}

	@Override
	public void delete(int bookID) {
		bookDao.delete(bookID);
	}

	@Override
	public List<BookInfo> getAll() {
		return bookDao.getAll();
	}

	@Override
	public List<BookInfo> getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

}

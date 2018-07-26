package tr.com.obss.dao.bookinfo;

import java.util.List;

import tr.com.obss.model.BookInfo;

public interface BookInfoDao {
	public BookInfo post(BookInfo book);

	public BookInfo get(int bookID);

	public BookInfo put(int bookID, BookInfo book);

	public void delete(int bookID);
	
	public List<BookInfo> getAll();
	
	public List<BookInfo> getBookByTitle(String title);
}

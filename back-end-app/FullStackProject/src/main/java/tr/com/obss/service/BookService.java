package tr.com.obss.service;

import tr.com.obss.model.Book;

public interface BookService {
	public Book post(Book book);

	public Book get(int bookID);

	public Book put(int bookID, Book book);

	public void delete(int bookID);
}

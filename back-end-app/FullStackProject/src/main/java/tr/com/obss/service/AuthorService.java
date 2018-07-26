package tr.com.obss.service;

import tr.com.obss.model.Author;

public interface AuthorService {
	public Author get(int authorID);
	public Author post(Author author);
	public Author put(int authorID,Author author);
	public void delete(int authorID);
}

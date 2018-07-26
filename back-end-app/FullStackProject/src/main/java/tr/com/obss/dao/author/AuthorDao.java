package tr.com.obss.dao.author;

import tr.com.obss.model.Author;

public interface AuthorDao {
	public Author get(int authorID);
	public Author post(Author author);
	public Author put(int authorID,Author author);
	public void delete(int authorID);
}

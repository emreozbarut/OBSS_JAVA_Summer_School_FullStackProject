package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.author.AuthorDao;
import tr.com.obss.model.Author;
import tr.com.obss.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public Author get(int authorID) {
		return authorDao.get(authorID);
	}

	@Override
	public Author post(Author author) {
		return authorDao.post(author);
	}

	@Override
	public Author put(int authorID, Author author) {
		return authorDao.put(authorID, author);
	}

	@Override
	public void delete(int authorID) {
		authorDao.delete(authorID);
	}

}

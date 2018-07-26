package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.favorite.FavoriteDao;
import tr.com.obss.model.Favorite;
import tr.com.obss.service.FavoriteService;
@Service
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	private FavoriteDao favoriteDao;
	
	@Override
	public Favorite post(Favorite favorite) {
		return favoriteDao.post(favorite);
	}

	@Override
	public Favorite get(int userID) {
		return favoriteDao.get(userID);
	}

	@Override
	public Favorite put(int userID, Favorite favorite) {
		return favoriteDao.put(userID, favorite);
	}

	@Override
	public void delete(int bookID) {
		favoriteDao.delete(bookID);
	}

}

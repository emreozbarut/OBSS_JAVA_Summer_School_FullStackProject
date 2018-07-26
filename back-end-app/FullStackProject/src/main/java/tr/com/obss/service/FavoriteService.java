package tr.com.obss.service;

import tr.com.obss.model.Favorite;

public interface FavoriteService {
	public Favorite post(Favorite favorite);

	public Favorite get(int userID);

	public Favorite put(int userID, Favorite fovorite);

	public void delete(int bookID);
}

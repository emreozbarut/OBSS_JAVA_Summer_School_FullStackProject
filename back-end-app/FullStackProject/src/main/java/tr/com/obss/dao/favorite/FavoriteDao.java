package tr.com.obss.dao.favorite;

import tr.com.obss.model.Favorite;

public interface FavoriteDao {
	public Favorite post(Favorite favorite);

	public Favorite get(int userID);

	public Favorite put(int userID, Favorite favorite);

	public void delete(int bookID);
}

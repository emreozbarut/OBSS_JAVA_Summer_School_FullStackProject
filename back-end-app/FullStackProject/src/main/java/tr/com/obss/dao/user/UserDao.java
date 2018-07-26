package tr.com.obss.dao.user;

import tr.com.obss.model.User;

public interface UserDao {
	public User post(User user);

	public User get(int userID);

	public User put(int userID, User user);
	
	public void delete(int userID);
}

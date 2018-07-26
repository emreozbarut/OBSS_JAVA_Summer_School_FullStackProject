package tr.com.obss.service;

import tr.com.obss.model.User;

public interface UserService {
	public User post(User user);

	public User get(int userID);
	
	public User put(int userID,User user);
	
	public void delete(int userID);
}

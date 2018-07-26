package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.user.UserDao;
import tr.com.obss.model.User;
import tr.com.obss.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public User post(User user) {
		return dao.post(user);
	}

	@Override
	public User get(int userID) {
		return dao.get(userID);
	}

	@Override
	public User put(int userID, User user) {
		return dao.put(userID,user);
	}

	@Override
	public void delete(int userID) {
		dao.delete(userID);
	}

}

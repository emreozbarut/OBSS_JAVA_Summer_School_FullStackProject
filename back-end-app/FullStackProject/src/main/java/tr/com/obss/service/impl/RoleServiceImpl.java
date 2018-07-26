package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.role.RoleDao;
import tr.com.obss.model.Role;
import tr.com.obss.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role post(Role role) {
		return roleDao.post(role);
	}

	@Override
	public Role get(int userID) {
		return roleDao.get(userID);
	}

	@Override
	public Role put(int userID, Role role) {
		return roleDao.put(userID, role);
	}

	@Override
	public void delete(int userID) {
		roleDao.delete(userID);
	}

}

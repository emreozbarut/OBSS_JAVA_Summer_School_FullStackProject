package tr.com.obss.service;

import tr.com.obss.model.Role;

public interface RoleService {
	public Role post(Role role);

	public Role get(int userID);

	public Role put(int userID, Role role);

	public void delete(int userID);
}

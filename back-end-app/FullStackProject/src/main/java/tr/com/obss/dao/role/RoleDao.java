package tr.com.obss.dao.role;

import tr.com.obss.model.Role;

public interface RoleDao {
	public Role post(Role role);

	public Role get(int userID);

	public Role put(int userID, Role role);

	public void delete(int userID);
}

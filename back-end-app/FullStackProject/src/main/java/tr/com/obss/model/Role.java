package tr.com.obss.model;

public class Role {
	private int userID;
	private String roleName;
	public Role(){
		
	}
	public Role(int userID, String roleName) {
		super();
		this.userID = userID;
		this.roleName = roleName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [userID=" + userID + ", roleName=" + roleName + "]";
	}
	
}

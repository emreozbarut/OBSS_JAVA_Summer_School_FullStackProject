package tr.com.obss.model;

public class User {
	private String username;
	private String email;
	private String password;
	private int userID;
	private int roleID;
	
	public User(){
		
	}
	
	public User(String username, String email, String password, int userID, int roleID) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.userID = userID;
		this.roleID = roleID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", userID=" + userID
				+ ", roleID=" + roleID + "]";
	}

}

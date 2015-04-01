
public class UserAccount {
	
	private String userID;
	private String password;
	private String salt;
	private String role;

	public void setUserID(String username) {
		this.userID = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserID() {
		return userID;
	}
	public String getPassword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	public String getRole() {
		return role;
	}
	
	

}

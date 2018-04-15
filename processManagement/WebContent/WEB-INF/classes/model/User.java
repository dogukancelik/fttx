package model;

public class User{
	
	private int userId;
	private String userName;
	private String password;
	
	private boolean status;
	
	public String getUsername() {
		return userName;
	}
	public int getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public boolean getStatus() {
		return status;
	}
	
	public void setUsername(String name) {
		userName = name;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	public void setStatus(boolean st) {
		status = st;
	}
}
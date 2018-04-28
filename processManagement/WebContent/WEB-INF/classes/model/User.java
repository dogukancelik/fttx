package model;

// http://www.ugurkizmaz.com/YazilimMakale-1625-Java-ile-MySQL-Baglantisi.aspx
public class User{
	
	private int userId;
	private String userName;
	private String password;
	private boolean status;
	
	
	// get functions
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public boolean getStatus() {
		return status;
	}
	
	
	
	//set functions
	public void setUserId(int Id) {
		userId = Id;
	}
	public void setUserName(String name) {
		userName = name;
	}
	public void setPassword(String pass) {
		password = pass;
	}
	public void setStatus(boolean st) {
		status = st;
	}
	
}
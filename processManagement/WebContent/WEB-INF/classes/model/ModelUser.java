package model;
public class ModelUser{
	private  int userId;
	private  String username;
	private  String password;
	private  byte status;
	public static String  GetModel="users";
	public static  String GetUserId="userId";
	public static String GetUsername="username";
	public static String GetPassword="password";
	public static String GetStatus="status";
	public void setUserId(int id) {
		this.userId=id;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setStatus(byte status) {
		this.status=status;
	}
	public  int getUserId() { return this.userId;}
	public String getUserName() {return this.username;}
	public String getPassword() {return this.password;}
	public byte getStatus() { return this.status;}
}
package model;

// http://www.ugurkizmaz.com/YazilimMakale-1625-Java-ile-MySQL-Baglantisi.aspx
public class User{
	
	private int userId;
	private String userName;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private String address;
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
	public String getName() {
		return name;
	}
	public String getSurName() {
		return surname;
	}
	public String getMail() {
		return mail;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
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
	public void setName(String n) {
		name = n;
	}
	public void setSurName(String sName) {
		surname = sName;
	}
	public void setMail(String m) {
		mail = m;
	}
	public void setPhone(String pho) {
		phone = pho;
	}
	public void setAddress(String adr) {
		address = adr;
	}
	public void setStatus(boolean st) {
		status = st;
	}
	
}
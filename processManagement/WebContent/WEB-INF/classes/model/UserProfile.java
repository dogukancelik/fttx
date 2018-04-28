package model;

public class UserProfile {
	private int userProfileId;
	private int userId;
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private String address;
	
	
	//get functions
	public int getUserProfileId() {
		return userProfileId;
	}
	public int getUserId() {
		return userId;
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
	
	//set functions
	public void setUserProfileId(int n) {
		userProfileId = n;
	}
	public void setUserId(int n) {
		userId = n;
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
}

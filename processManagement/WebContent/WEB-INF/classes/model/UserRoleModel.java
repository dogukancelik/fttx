package model;
public class UserRoleModel {
	
	public static String GetModelName="userrolename";
	public static String GetUserRoleId="UserRoleId";
	public static String GetUserId="UserId";
	public static String GetRoleId="RoleId";
	public static String GetUserRolDesciription="UserRolDesciription";
	 private  int UserRoleId;
	 private  int UserId;
	 private  int RoleId;
	 private  String UserRolDesciription;
	
	public String [] ModelArrayString() {
		String [] a=new String[] {"UserRoleId","UserId","RoleId","UserRolDesciription"};
		return a;
	}
	public int getUserRoleId() {
		return UserRoleId;
	}
	
	public int getUserId() {
		return UserId;
	}
	public int getRoleId() {
		return RoleId;
	}
	public String getUserRolDesciription() {
		return UserRolDesciription;
	}
	public void setUserRoleId(int n) {
		UserRoleId = n;
	}
	
	public void setUserId(int n) {
		UserId = n;
	}
	public void setRoleId(int  sName) {
		RoleId = sName;
	}
	public void setUserRolDesciription(String sName) {
		UserRolDesciription = sName;
	}
	
}
	
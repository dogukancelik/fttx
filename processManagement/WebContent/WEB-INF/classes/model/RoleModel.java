package model;

public class RoleModel {
	
	public static String GetModelName="role";
	public static String GetRoleId="RoleId";
	public static String GetRoleName="RoleName";
	public static String GetRoleDescription="RolDescription";
	private  int RoleId;
	 private String RoleName;
	 private String RoleDescription;
	 
	public String [] ModelArrayString() {
		String [] a=new String[] {"RoleId","RoleName","RolDescription"};
		return a;
	}
	public int getRoleId() {
		return RoleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public String getRoleDescription() {
		return RoleDescription;
	}
	public void setRoleId(int n) {
		RoleId = n;
	}
	public void setRoleName(String  sName) {
		RoleName = sName;
	}
	public void setRoleDescription(String des)
	{
		RoleDescription=des;
	}
	
}
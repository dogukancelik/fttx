package model;
public class RoleProcessModel {
	
	public static String GetModelName="roleprocess";
	public static String GetRoleProcessId="RoleProcessId";
	public static String GetRoleId="RoleId";
	public static String GetProcessId="ProcessId";
	 private  int RolePocessId;
	 private  int RoleId;
	 private int ProcessId;
	 
	public String [] ModelArrayString() {
		String [] a=new String[] {"RoleProcessId","RoleId","ProcessId"};
		return a;
	}
	public int getRoleProcessId() {
		return RolePocessId;
	}
	
	public int getRoleId() {
		return RoleId;
	}
	public int getProcessId() {
		return ProcessId;
	}
	
	public void setRoleProcessId(int n) {
		RolePocessId = n;
	}
	
	public void setRoleId(int n) {
		RoleId = n;
	}
	public void setProcessId(int  sName) {
		ProcessId = sName;
	}
	
}
	
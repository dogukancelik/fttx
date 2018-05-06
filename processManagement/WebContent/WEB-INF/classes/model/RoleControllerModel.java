package model;

public class RoleControllerModel {

	public static String GetModelName="rolecontroller";
	public static String GetRoleControllerId="RoleControllerId";
	public static String GetRoleId="RoleId";
	public static String GetControllerId="ControllerId";
	private  int RoleControllerId;
	private int RoleId;
	private int ControlerId;
	
	public String [] ModelArrayString() {
		String [] a=new String[] {"RoleControllerId","RoleId","ControllerId"};
		return a;
	}
	public int getRoleControllerId() {
		return RoleControllerId;
	}
	public int getRoleId() {
		return RoleId;
	}
	public int getControlerId() {
		return ControlerId;
	}
	public void setRoleControllerId(int srct) {
		RoleControllerId = srct;
	}
	public void setRoleId(int srl) {
		RoleId = srl;
	}
	public void setControlerId(int sct) {
		ControlerId = sct;
	}
	
}

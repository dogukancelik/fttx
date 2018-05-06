package model;

public class ControllerModel {
	
	public static String GetModelName="controller";
	public static String GetControllerId="ControllerId";
	public static String GetSubControllerId="SubControllerId";
	public static String GetControllerName="ControllerName";
	public static String GetActionName="ActionName";
	private  int ControllerId;
	private  int SubControllerId;
	 private String ControllerName;
	 private String ActionName;
	 
	public String [] ModelArrayString() {
		String [] a=new String[] {"ControllerId","SubControllerId","ControllerName","ActionName"};
		return a;
	}
	public int getControllerId() {
		return ControllerId;
	}
	public int getSubControllerId() {
		return SubControllerId;
	}
	public String getControllerName() {
		return ControllerName;
	}
	public String getActionName() {
		return ActionName;
	}
	public void setControllerId(int n) {
		ControllerId = n;
	}
	public void setSubControllerId(int sbc) {
		SubControllerId = sbc;
	}
	public void setControllerName(String  sName) {
		ControllerName = sName;
	}
	public void setActionName(String des)
	{
		ActionName=des;
	}
	
}
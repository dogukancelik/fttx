package model;

public class ProcessModel {
	
	public static String GetModelName="process";
	public static String GetProcessId="ProcessId";
	public static String GetProcessName="ProcessName";
	public static String GetProcessDescription="ProcessDescription";
	private  int ProcessId;
	private String ProcessName;
	private String ProcessDescription;
	public String [] ModelArrayString() {
		String [] a=new String[] {"ProcessId","ProcessName","ProcessDescription"};
		return a;
	}
	public int getProcessId() {
		return ProcessId;
	}
	public String getProcessName() {
		return ProcessName;
	}
	public String getProcessDescription() {
		return ProcessDescription;
	}
	public void setProcessId(int n) {
		ProcessId = n;
	}
	public void setProcessName(String  sName) {
		ProcessName = sName;
	}
	public void setProcessDescription(String des)
	{
		ProcessDescription=des;
	}
	
}
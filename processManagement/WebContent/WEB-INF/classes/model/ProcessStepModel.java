package model;
public class ProcessStepModel {
	public static String GetModelName="processstep";
	public static String GetProcessStepId="ProcessStepId";
	public static String GetUserId="UserId";
	public static String GetProcess="ProcessId";
	public static String GetProcessDate="ProcessDate";
	private  int ProcessStepId;
	private int ProcessId;
	private int UserId;
	private String ProcessDate;
	public String [] ModelArrayString() {
		String [] a=new String[] {"ProcessStepId","UserId","ProcessId","ProcessDate"};
		return a;
	}
	public int getProcessStepId() {
		return ProcessStepId;
	}
	public int getUserId() {
		return UserId;
	}
	public int getProcessId() {
		return ProcessId;
	}
	public String getProcessDate() {
		return ProcessDate;
	}
	public void setProcessStepId(int n) {
		ProcessStepId = n;
	}
	public void setUserId(int  sUs) {
		UserId = sUs;
	}
	public void setProcessId(int  sPro) {
		ProcessId = sPro;
	}
	public void setProcessDate(String date)
	{
		ProcessDate=date;
	}
	
}
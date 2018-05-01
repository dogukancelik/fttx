package model;
public class ProcessStepModel {
	public static String GetModelName="processstep";
	public static String GetProcessStepId="ProcessStepId";
	public static String GetUserId="UserId";
	public static String GetProcessDate="ProcessDate";
	private  int ProcessStepId;
	private int UserId;
	private String ProcessDate;
	public String [] ModelArrayString() {
		String [] a=new String[] {"ProcessStepId","UserId","ProcessDate"};
		return a;
	}
	public int getProcessStepId() {
		return ProcessStepId;
	}
	public int getUserId() {
		return UserId;
	}
	public String getProcessDate() {
		return ProcessDate;
	}
	public void setProcessStepId(int n) {
		ProcessStepId = n;
	}
	public void setUserId(int  sName) {
		UserId = sName;
	}
	public void setProcessDate(String des)
	{
		ProcessDate=des;
	}
	
}
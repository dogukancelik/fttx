package model;

public class ProcessOrderModel {
	
	public static String GetModelName="processorder";
	public static String GetProcessOrderId="ProcessOrderId";
	public static String GetWorkDefinitionId="WorkDefinitionId";
	public static String GetProcessId="ProcessId";
	public static String GetOrder="ProcessOrder";
	public static String GetCheck="ProcessCheck";
	private  int ProcessOrderId;
	private int WorkDefinitionId;
	private int ProcessId;
	private int ProcessOrder;
	private boolean ProcessCheck;
	public String [] ModelArrayString() {
		String [] a=new String[] {"ProcessOrderId","WorkDefinitionId","ProcessId","ProcessOrder","ProcessCheck"};
		return a;
	}
	public int getProcessOrderId() {
		return ProcessOrderId;
	}
	public int getWorkDefinitionId() {
		return WorkDefinitionId;
	}
	public int getProcessId() {
		return ProcessId;
	}
	public int getProcessOrder() {
		return ProcessOrder;
	}
	public boolean getProcessCheck() {
		return ProcessCheck;
	}
   	public void setProcessOrderId(int Po) {
		ProcessOrderId=Po;
	}
	public void setProcessId(int n) {
		ProcessId = n;
	}
	public void setProcessOrder(int sName) {
		ProcessOrder = sName;
	}
	public void setWorkDefinitionId(int des)
	{
	WorkDefinitionId=des;
	}
	public void setProcessCheck(boolean chk)
	{
		ProcessCheck=chk;
	}
}
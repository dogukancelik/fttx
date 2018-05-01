package model;

public class WorkDefinitionModel{
	
	public static String GetModelName="workdefinition";
	public static String GetWorkDefinitionId="WorkDefinitionId";
	public static String GetWorkDefinitionName="WorkDefinitionName";
	public static String GetWorkDefinitionDesciription="WorkDefinitionDesciription";
	private  int WorkDefinitionId;
	private  String WorkDefinitionName;
	private  String WorkDefinitionDesciription;
	
	public String [] ModelArrayString() {
		String [] a=new String[] {"WorkDefinitionId","WorkDefinitionName","WorkDefinitionDesciription"};
		return a;
	}
	public int getWorkDefinitionId() {
		return WorkDefinitionId;
	}
	
	public String getWorkDefinitionName() {
		return WorkDefinitionName;
	}
	public String getWorkDefinitionDesciription() {
		return WorkDefinitionDesciription;
	}
	
	public void setWorkDefinitionId(int n) {
		WorkDefinitionId = n;
	}
	
	public void setWorkDefinitionName(String n) {
		WorkDefinitionName = n;
	}
	public void setWorkDefinitionDesciription(String sName) {
		WorkDefinitionDesciription = sName;
	}
	
}
	

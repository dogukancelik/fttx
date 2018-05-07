package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.RoleProcessModel;
import model.WorkDefinitionModel;;

public class WORKDEFINITION {

	public	String[] model=new String[3];
	private void model_doldur(WorkDefinitionModel m){

		model[0]=String.valueOf(m.getWorkDefinitionId());
		model[1]=m.getWorkDefinitionName();
		model[2]=m.getWorkDefinitionDesciription().toString();
		
	}
	
	public WorkDefinitionModel modeldoldur (HttpServletRequest s)
	{
		WorkDefinitionModel us =new WorkDefinitionModel();
 
		us.setWorkDefinitionDesciription(s.getParameter(us.GetWorkDefinitionDesciription));
		us.setWorkDefinitionId(Integer.parseInt(s.getParameter(us.GetWorkDefinitionId)!=null?s.getParameter(us.GetWorkDefinitionId):"0"));
		us.setWorkDefinitionName(s.getParameter(us.GetWorkDefinitionName));

		return us;
	}
	
	 WorkDefinitionModel WorkDefinitionModel=new WorkDefinitionModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<WorkDefinitionModel> GetroleList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<WorkDefinitionModel> workdefinition =new ArrayList<WorkDefinitionModel>();
	    a=cr.GetList(WorkDefinitionModel.ModelArrayString(),WorkDefinitionModel.GetModelName);
		for(String []  lst : a) {
			WorkDefinitionModel.setWorkDefinitionId(Integer.parseInt(lst[0].toString()));
			WorkDefinitionModel.setWorkDefinitionName(lst[0].toString());
			WorkDefinitionModel.setWorkDefinitionDesciription(lst[3].toString());
			workdefinition.add(WorkDefinitionModel);
	}
		return workdefinition;
		}
	public ArrayList<WorkDefinitionModel> GetroleList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<WorkDefinitionModel> workdefinition =new ArrayList<WorkDefinitionModel>();
	    a=cr.GetListId(WorkDefinitionModel.ModelArrayString(),WorkDefinitionModel.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			WorkDefinitionModel.setWorkDefinitionId(Integer.parseInt(lst[0].toString()));
			WorkDefinitionModel.setWorkDefinitionName(lst[0].toString());
			WorkDefinitionModel.setWorkDefinitionDesciription(lst[3].toString());
			workdefinition.add(WorkDefinitionModel);
	}
		return workdefinition;
		}
	public int Create(WorkDefinitionModel model_) throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
			a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (WorkDefinitionModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetWorkDefinitionId, String.valueOf(model_.getWorkDefinitionId()));
		return a;
	}
	public int Delete (WorkDefinitionModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetWorkDefinitionId ,String.valueOf(model.getWorkDefinitionId()));
		return a;
	}
	
	
	
	
}

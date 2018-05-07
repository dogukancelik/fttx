package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.RoleControllerModel;
import model.RoleProcessModel;

public class ROLEPROCESS {

	public	String[] model=new String[3];
	public RoleProcessModel modeldoldur (HttpServletRequest s)
	{
		RoleProcessModel us =new RoleProcessModel();
		us.setProcessId(Integer.parseInt(s.getParameter(us.GetProcessId)!=null?s.getParameter(us.GetProcessId):"0"));
		us.setRoleId(Integer.parseInt(s.getParameter(us.GetRoleId)!=null?s.getParameter(us.GetRoleId):"0"));
		us.setRoleProcessId(Integer.parseInt(s.getParameter(us.GetRoleProcessId)!=null?s.getParameter(us.GetRoleProcessId):"0"));
		return us;
	}
	private void model_doldur(RoleProcessModel m){

		model[0]=String.valueOf(m.getRoleProcessId());
		model[1]=String.valueOf(m.getRoleId());
		model[2]=String.valueOf(m.getProcessId());
	 }
	RoleProcessModel roleProcess=new RoleProcessModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<RoleProcessModel> GetroleProcessList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleProcessModel> roleProcessArray =new ArrayList<RoleProcessModel>();
	    a=cr.GetList(roleProcess.ModelArrayString(),roleProcess.GetModelName);
		for(String []  lst : a) {
	    roleProcess.setRoleProcessId(Integer.parseInt(lst[0].toString()));
		roleProcess.setRoleId(Integer.parseInt(lst[1].toString()));
		roleProcess.setProcessId(Integer.parseInt(lst[2].toString()));
   roleProcessArray.add(roleProcess);
	}
		return roleProcessArray;
		}
	public ArrayList<RoleProcessModel> GetroleProcessList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleProcessModel> roleProcessArray =new ArrayList<RoleProcessModel>();
	    a=cr.GetListId(roleProcess.ModelArrayString(),roleProcess.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			 roleProcess.setRoleProcessId(Integer.parseInt(lst[0].toString()));
				roleProcess.setRoleId(Integer.parseInt(lst[1].toString()));
				roleProcess.setProcessId(Integer.parseInt(lst[2].toString()));
		roleProcessArray.add(roleProcess);
	}
		return roleProcessArray;
		}
	public int Create(RoleProcessModel model_) throws ClassNotFoundException, SQLException {
		int a; 	model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (RoleProcessModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetRoleProcessId, String.valueOf(model_.getRoleProcessId()));
		return a;
	}
	public int Delete (RoleProcessModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetRoleProcessId ,String.valueOf(model.getRoleProcessId()));
		return a;
	}


}

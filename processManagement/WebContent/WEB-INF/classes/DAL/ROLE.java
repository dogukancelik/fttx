package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.ProcessStepModel;
import model.RoleModel;

public class ROLE {

	public	String[] model=new String[3];
	public RoleModel modeldoldur (HttpServletRequest s)
	{
		RoleModel us =new RoleModel();
		us.setRoleDescription(s.getParameter(us.GetRoleDescription));
		us.setRoleId(Integer.parseInt(s.getParameter(us.GetRoleId)!=null?s.getParameter(us.GetRoleId):"0"));
		us.setRoleName(s.getParameter(us.GetRoleName));
		return us;
	 }
	private void model_doldur(RoleModel m){

		model[0]=String.valueOf(m.getRoleId());
		model[1]=m.getRoleName().toString();
		model[2]=m.getRoleDescription().toString();
		
	}
	RoleModel role=new RoleModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<RoleModel> GetroleList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleModel> roleArray =new ArrayList<RoleModel>();
	    a=cr.GetList(role.ModelArrayString(),role.GetModelName);
		for(String []  lst : a) {
	    role.setRoleId(Integer.parseInt(lst[0].toString()));
		role.setRoleName(lst[1].toString());
		role.setRoleDescription(lst[2].toString());
   roleArray.add(role);
	}
		return roleArray;
		}
	public ArrayList<RoleModel> GetroleList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleModel> roleArray =new ArrayList<RoleModel>();
	    a=cr.GetListId(role.ModelArrayString(),role.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			  role.setRoleId(Integer.parseInt(lst[0].toString()));
				role.setRoleName(lst[1].toString());
				role.setRoleDescription(lst[2].toString());
		roleArray.add(role);
	}
		return roleArray;
		}
	public int Create(RoleModel model_) throws ClassNotFoundException, SQLException {
		int a;
		model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (RoleModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetRoleId, String.valueOf(model_.getRoleId()));
		return a;
	}
	public int Delete (RoleModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetRoleId ,String.valueOf(model.getRoleId()));
		return a;
	}
	
}

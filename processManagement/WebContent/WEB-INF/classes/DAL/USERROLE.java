package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.RoleProcessModel;
import model.UserRoleModel;

public class USERROLE {

	public	String[] model=new String[4];
	private void model_doldur(UserRoleModel m){

		model[0]=String.valueOf(m.getUserRoleId());
		model[1]=String.valueOf(m.getUserId());
		model[1]=String.valueOf(m.getRoleId());
		model[2]=m.getUserRoleDescription().toString();
		
	}
	public UserRoleModel modeldoldur (HttpServletRequest s)
	{
		UserRoleModel us =new UserRoleModel();
		
		us.setRoleId(Integer.parseInt(s.getParameter(us.GetRoleId)!=null?s.getParameter(us.GetRoleId):"0"));
		us.setUserId(Integer.parseInt(s.getParameter(us.GetUserId)!=null?s.getParameter(us.GetUserId):"0"));
		us.setUserRoleDescription(s.getParameter(us.GetUserRolDesciription));
		us.setUserRoleId(Integer.parseInt(s.getParameter(us.GetUserRoleId)!=null?s.getParameter(us.GetUserRoleId):"0"));
		
		return us;
	}
	
	 UserRoleModel UserRoleModel=new UserRoleModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<UserRoleModel> GetRoleList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<UserRoleModel> UserroleArray =new ArrayList<UserRoleModel>();
	    a=cr.GetList(UserRoleModel.ModelArrayString(),UserRoleModel.GetModelName);
		for(String []  lst : a) {
			UserRoleModel.setUserRoleId(Integer.parseInt(lst[0].toString()));
			UserRoleModel.setUserId(Integer.parseInt(lst[1].toString()));
			UserRoleModel.setRoleId(Integer.parseInt(lst[2].toString()));
			UserRoleModel.setUserRoleDescription(lst[3].toString());
			UserroleArray.add(UserRoleModel);
	}
		return UserroleArray;
		}
	public ArrayList<UserRoleModel> GetRoleList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<UserRoleModel> UserroleArray =new ArrayList<UserRoleModel>();
	    a=cr.GetListId(UserRoleModel.ModelArrayString(),UserRoleModel.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			UserRoleModel.setUserRoleId(Integer.parseInt(lst[0].toString()));
			UserRoleModel.setUserId(Integer.parseInt(lst[1].toString()));
			UserRoleModel.setRoleId(Integer.parseInt(lst[2].toString()));
			UserRoleModel.setUserRoleDescription(lst[3].toString());
			UserroleArray.add(UserRoleModel);
	}
		return UserroleArray;
		}
	public int Create(UserRoleModel model_) throws ClassNotFoundException, SQLException {
		int a;	model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (UserRoleModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetUserRoleId, String.valueOf(model_.getUserRoleId()));
		return a;
	}
	public int Delete (UserRoleModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetUserRoleId ,String.valueOf(model.getUserRoleId()));
		return a;
	}
	
	
	
}

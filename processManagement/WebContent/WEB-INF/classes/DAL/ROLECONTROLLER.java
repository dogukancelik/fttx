package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.RoleControllerModel;
import model.RoleModel;

public class ROLECONTROLLER {

	public	String[] model=new String[3];
	private void model_doldur(RoleControllerModel m){

		model[0]=String.valueOf(m.getRoleControllerId());
		model[1]=String.valueOf(m.getControlerId());
		model[2]=String.valueOf(m.getRoleId());
		
		
	}
	public RoleControllerModel modeldoldur (HttpServletRequest s)
	{
		RoleControllerModel us =new RoleControllerModel();
		us.setControlerId(Integer.parseInt(s.getParameter(us.GetControllerId)!=null?s.getParameter(us.GetControllerId):"0"));
		us.setRoleControllerId(Integer.parseInt(s.getParameter(us.GetRoleControllerId)!=null?s.getParameter(us.GetRoleControllerId):"0"));
		us.setRoleId(Integer.parseInt(s.getParameter(us.GetRoleId)!=null?s.getParameter(us.GetRoleId):"0"));
		
		return us;
	}
	
	RoleControllerModel control=new RoleControllerModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<RoleControllerModel> GetcontrolList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleControllerModel> controlArray =new ArrayList<RoleControllerModel>();
	    a=cr.GetList(control.ModelArrayString(),control.GetModelName);
		for(String []  lst : a) {
		control.setRoleControllerId(Integer.parseInt(lst[0].toString()));
		control.setRoleId(Integer.parseInt(lst[1].toString()));
		control.setControlerId(Integer.parseInt(lst[2].toString()));
	   
   controlArray.add(control);
	}
		return controlArray;
		}
	public ArrayList<RoleControllerModel> GetcontrolList(String WhereItem,String WhereValue,String kosul) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<RoleControllerModel> controlArray =new ArrayList<RoleControllerModel>();
	    a=cr.GetListId(control.ModelArrayString(),control.GetModelName,WhereItem,WhereValue,kosul);
		for(String []  lst : a) {
			control.setRoleControllerId(Integer.parseInt(lst[0].toString()));
			control.setRoleId(Integer.parseInt(lst[1].toString()));
			control.setControlerId(Integer.parseInt(lst[2].toString()));
	   controlArray.add(control);
	}
		return controlArray;
		}
	public int Create(RoleControllerModel model_) throws ClassNotFoundException, SQLException {
		int a;	model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (RoleControllerModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetRoleControllerId, String.valueOf(model_.getRoleControllerId()));
		return a;
	}
	public int Delete (RoleControllerModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetRoleControllerId ,String.valueOf(model.getRoleControllerId()));
		return a;
	}
	


}

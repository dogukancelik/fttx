package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBContext.CRUD;
import model.ControllerModel;

public class CONTROLLER {

	public	String[] model=new String[4];
	private void model_doldur(ControllerModel m){

		model[0]=String.valueOf(m.getControllerId());
		model[1]=String.valueOf(m.getSubControllerId());
		model[2]=m.getControllerName().toString();
		model[3]=m.getActionName().toString();
		
	}
	ControllerModel control=new ControllerModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<ControllerModel> GetcontrolList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ControllerModel> controlArray =new ArrayList<ControllerModel>();
	    a=cr.GetList(control.ModelArrayString(),control.GetModelName);
		for(String []  lst : a) {
		control.setControllerId(Integer.parseInt(lst[0].toString()));
	    control.setSubControllerId(Integer.parseInt(lst[1].toString()));
		control.setControllerName(lst[2].toString());
		control.setActionName(lst[3].toString());
   controlArray.add(control);
	}
		return controlArray;
		}
	public ArrayList<ControllerModel> GetcontrolList(String WhereItem,String WhereValue,String kosul) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ControllerModel> controlArray =new ArrayList<ControllerModel>();
	    a=cr.GetListId(control.ModelArrayString(),ControllerModel.GetModelName,WhereItem,WhereValue,kosul.toString());
		for(String []  lst : a) {
			control.setControllerId(Integer.parseInt(lst[0].toString()));
		    control.setSubControllerId(Integer.parseInt(lst[1].toString()));
			control.setControllerName(lst[2].toString());
			control.setActionName(lst[3].toString());
	   controlArray.add(control);
	}
		return controlArray;
		}
	public int Create(ControllerModel model_) throws ClassNotFoundException, SQLException {
		int a;
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (ControllerModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetControllerId, String.valueOf(model_.getControllerId()));
		return a;
	}
	public int Delete (ControllerModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetControllerId ,String.valueOf(model.getControllerId()));
		return a;
	}
	

}

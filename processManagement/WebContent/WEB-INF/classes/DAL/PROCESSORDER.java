package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import DBContext.CRUD;
import model.ModelUser;
import model.ProcessOrderModel;

public class PROCESSORDER {

	public	String[] model=new String[5];
	private void model_doldur(ProcessOrderModel m){

		model[0]=String.valueOf(m.getProcessOrderId());
		model[0]=String.valueOf(m.getWorkDefinitionId());
		model[0]=String.valueOf(m.getProcessId());
		model[0]=String.valueOf(m.getProcessOrder());
		model[0]=String.valueOf(String.valueOf(m.getProcessCheck()));
		}
	 public ProcessOrderModel modeldoldur (HttpServletRequest s)
	{
		ProcessOrderModel us =new ProcessOrderModel();
		us.setProcessCheck(Boolean.parseBoolean(s.getParameter(us.GetCheck)));
		us.setProcessId(Integer.parseInt(s.getParameter(us.GetProcessId)!=null?s.getParameter(us.GetProcessId):"0"));
		us.setProcessOrder(Integer.parseInt(s.getParameter(us.GetOrder)!=null?s.getParameter(us.GetOrder):"0"));
		us.setProcessOrderId(Integer.parseInt(s.getParameter(us.GetProcessOrderId)!=null?s.getParameter(us.GetProcessOrderId):"0"));
		us.setWorkDefinitionId(Integer.parseInt(s.getParameter(us.GetWorkDefinitionId)!=null?s.getParameter(us.GetWorkDefinitionId):"0"));
		return us;
	}
	ProcessOrderModel processOrder=new ProcessOrderModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<ProcessOrderModel> GetProcessOrderList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ProcessOrderModel> processArray =new ArrayList<ProcessOrderModel>();
	    a=cr.GetList(processOrder.ModelArrayString(),processOrder.GetModelName);
		for(String []  lst : a) {
   processArray.add(processOrder);
   processOrder.setProcessOrderId(Integer.parseInt(lst[0].toString()));
	processOrder.setWorkDefinitionId(Integer.parseInt(lst[1].toString()));
	processOrder.setProcessId(Integer.parseInt(lst[2].toString()));
	processOrder.setProcessOrder(Integer.parseInt(lst[3].toString()));
	processOrder.setProcessCheck(Boolean.parseBoolean(lst[1].toString()));
	}
		
		return processArray;
		}
	public ArrayList<ProcessOrderModel> GetProcessOrderList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ProcessOrderModel> processArray =new ArrayList<ProcessOrderModel>();
	    a=cr.GetListId(processOrder.ModelArrayString(),processOrder.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			processOrder.setProcessOrderId(Integer.parseInt(lst[0].toString()));
			processOrder.setWorkDefinitionId(Integer.parseInt(lst[1].toString()));
			processOrder.setProcessId(Integer.parseInt(lst[2].toString()));
			processOrder.setProcessOrder(Integer.parseInt(lst[3].toString()));
			processOrder.setProcessCheck(Boolean.parseBoolean(lst[1].toString()));
		processArray.add(processOrder);
	}
		return processArray;
		}
	public int Create(ProcessOrderModel model_) throws ClassNotFoundException, SQLException {
		int a;	model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (ProcessOrderModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetProcessOrderId, String.valueOf(model_.getProcessOrderId()));
		return a;
	}
	public int Delete (ProcessOrderModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetProcessOrderId ,String.valueOf(model.getProcessOrderId()));
		return a;
	}
}

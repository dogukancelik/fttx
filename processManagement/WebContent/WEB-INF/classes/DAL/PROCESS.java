package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.ProcessModel;
import DBContext.CRUD;
import model.UserProfileModel;

public class PROCESS {

	public	String[] model=new String[3];
	private void model_doldur(ProcessModel m){

		model[0]=String.valueOf(m.getProcessId());
		model[1]=m.getProcessName().toString();
		model[2]=m.getProcessDescription().toString();
		
	}
	public ProcessModel modeldoldur (HttpServletRequest s)
	 {
		ProcessModel us =new ProcessModel();
		us.setProcessDescription(s.getParameter(us.GetProcessDescription));
		us.setProcessId(Integer.parseInt(s.getParameter(us.GetProcessId)!=null ?s.getParameter(us.GetProcessId):"0"));
		us.setProcessName(s.getParameter(us.GetProcessName));
		return us;
	}
	ProcessModel process=new ProcessModel();
	CRUD cr=new CRUD();

	@SuppressWarnings("static-access")
	public ArrayList<ProcessModel> GetProcessList() throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ProcessModel> processArray =new ArrayList<ProcessModel>();
	    a=cr.GetList(process.ModelArrayString(),process.GetModelName);
		for(String []  lst : a) {
	    process.setProcessId(Integer.parseInt(lst[0].toString()));
		process.setProcessName(lst[1].toString());
		process.setProcessDescription(lst[2].toString());
   processArray.add(process);
	}
		return processArray;
		}
	public ArrayList<ProcessModel> GetProcessList(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException
	{
		List<String[]> a= new ArrayList<String[]>();
	    ArrayList<ProcessModel> processArray =new ArrayList<ProcessModel>();
	    a=cr.GetListId(process.ModelArrayString(),process.GetModelName,WhereItem,WhereValue,null);
		for(String []  lst : a) {
			  process.setProcessId(Integer.parseInt(lst[0].toString()));
				process.setProcessName(lst[1].toString());
				process.setProcessDescription(lst[2].toString());
		processArray.add(process);
	}
		return processArray;
		}
	public int Create(ProcessModel model_) throws ClassNotFoundException, SQLException {
		int a;
		model_doldur(model_);
		a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
		return a;
	}

	public int Edit (ProcessModel model_)throws ClassNotFoundException, SQLException {
		model_doldur(model_);
		int a;
		a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetProcessId, String.valueOf(model_.getProcessId()));
		return a;
	}
	public int Delete (ProcessModel model)throws ClassNotFoundException, SQLException {

		int a;
		a=cr.Delete(model.GetModelName,model.GetProcessId ,String.valueOf(model.getProcessId()));
		return a;
	}
	
}

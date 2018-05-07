package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DBContext.CRUD;
import model.ModelUser;
import model.UserProfileModel;

public class USERPROFILE {

	
public UserProfileModel modeldoldur (HttpServletRequest s)
{
	UserProfileModel us =new UserProfileModel();
	
	us.setUserProfileId(Integer.parseInt(s.getParameter(us.GetUserProfileId)!=null?s.getParameter(us.GetUserProfileId):"0"));
	us.setUserId(Integer.parseInt(s.getParameter(us.GetUserId)!=null?s.getParameter(us.GetUserId):"0"));
	us.setName(s.getParameter(us.GetMail));
	us.setSurName(s.getParameter(us.GetSurname));
	us.setMail(s.getParameter(us.GetMail));
	us.setPhone(s.getParameter(us.GetPhone));
	us.setAddress(s.getParameter(us.GetAddress));
	return us;
}

public	String[] model=new String[7];
private void model_doldur(UserProfileModel m){

	model[0]=String.valueOf(m.getUserProfileId());
	model[1]=String.valueOf(m.getUserId());
	model[2]=m.getName().toString();
	model[3]=m.getSurName().toString();
	model[4]=m.getMail().toString();
	model[5]=m.getPhone().toString();
	model[6]=m.getAddress().toString();
	
 }
UserProfileModel profile=new UserProfileModel();
CRUD cr=new CRUD();

@SuppressWarnings("static-access")
public ArrayList<UserProfileModel> GetUserProfileList() throws ClassNotFoundException, SQLException
{
	List<String[]> a= new ArrayList<String[]>();
    ArrayList<UserProfileModel> profileArray =new ArrayList<UserProfileModel>();
    a=cr.GetList(profile.ModelArrayString(),profile.GetModelName);
	for(String []  lst : a) {
    profile.setUserProfileId(Integer.parseInt(lst[0].toString()));
	profile.setUserId(Integer.parseInt(lst[1].toString()));	
	profile.setName(lst[2].toString());
	profile.setSurName(lst[3].toString());
	profile.setMail(lst[4].toString());
	profile.setPhone(lst[5].toString());
	profile.setAddress(lst[6].toString());
	profileArray.add(profile);
}
	return profileArray;
	}
public ArrayList<UserProfileModel> GetUserProfileListId(String WhereItem,String WhereValue,String kosul) throws ClassNotFoundException, SQLException
{
	List<String[]> a= new ArrayList<String[]>();
    ArrayList<UserProfileModel> profileArray =new ArrayList<UserProfileModel>();
    a=cr.GetListId(profile.ModelArrayString(),profile.GetModelName,WhereItem.toString(),WhereValue.toString(),kosul.toString());
	for(String []  lst : a) {
    profile.setUserProfileId(Integer.parseInt(lst[0].toString()));
	profile.setUserId(Integer.parseInt(lst[1].toString()));	
	profile.setName(lst[2].toString());
	profile.setSurName(lst[3].toString());
	profile.setMail(lst[4].toString());
	profile.setPhone(lst[5].toString());
	profile.setAddress(lst[6].toString());
	profileArray.add(profile);
}
	return profileArray;
	}
public int Create(UserProfileModel model_) throws ClassNotFoundException, SQLException {
	int a;	model_doldur(model_);
	a=cr.Create(model_.ModelArrayString() ,model, model_.GetModelName);  
	return a;
}

public int Edit (UserProfileModel model_)throws ClassNotFoundException, SQLException {
	model_doldur(model_);
	int a;
	a=cr.Update(model_.ModelArrayString(), model, model_.GetModelName, model_.GetUserProfileId, String.valueOf(model_.getUserProfileId()));
	return a;
}
public int Delete (UserProfileModel model)throws ClassNotFoundException, SQLException {

	int a;
	a=cr.Delete(model.GetModelName,model.GetUserProfileId ,String.valueOf(model.getUserProfileId()));
	return a;
}


}

package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBContext.CRUD;
import model.ModelUser;
import model.UserProfileModel;

public class USERPROFILE {

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
public int Create(UserProfileModel model_) throws ClassNotFoundException, SQLException {
	int a;
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

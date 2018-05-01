package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;

import DBContext.CRUD;
import model.ModelUser;
import model.UserProfileModel;

public class USERPROFILE {

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
}

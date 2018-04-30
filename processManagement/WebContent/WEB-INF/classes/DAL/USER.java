package DAL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import DBContext.CRUD;
import model.ModelUser;
public class USER {
	CRUD cr=new CRUD();
@SuppressWarnings({ "unchecked"})
public ArrayList<ModelUser> getUserList() throws ClassNotFoundException, SQLException {
    List<String[]> a= new ArrayList<String[]>();
     ArrayList<ModelUser> Users=new ArrayList<ModelUser>();
    a=cr.GetList(new String [] {ModelUser.GetUserId,ModelUser.GetUsername,ModelUser.GetPassword,ModelUser.GetStatus});
	for(String []  lst : a) {
	ModelUser user=new ModelUser();
	user.setUserId(Integer.parseInt(lst[0].toString()));
    user.setUserName(lst[1].toString());
    user.setPassword(lst[2].toString());
    user.setStatus(Byte.parseByte("0"));
        Users.add(user);
	}
	 return Users;
   }
	}


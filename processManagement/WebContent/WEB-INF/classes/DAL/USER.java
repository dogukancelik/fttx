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
    a=cr.GetList(new String [] {ModelUser.GetUserId,ModelUser.GetUsername,ModelUser.GetPassword,ModelUser.GetStatus},ModelUser.GetModel);
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
public ArrayList<ModelUser> getUserListId(String WhereItem,String WhereValue) throws ClassNotFoundException, SQLException {
    List<String[]> a= new ArrayList<String[]>();
     ArrayList<ModelUser> Users=new ArrayList<ModelUser>();
    a=cr.GetListId(new String [] {ModelUser.GetUserId,ModelUser.GetUsername,ModelUser.GetPassword,ModelUser.GetStatus},ModelUser.GetModel,WhereItem,WhereValue);
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
public int Create(ModelUser model) throws ClassNotFoundException, SQLException {
	int a;
	a=cr.Create(new String [] {ModelUser.GetUsername,ModelUser.GetPassword,ModelUser.GetStatus},new String [] {model.getUserName().toString(),model.getPassword().toString(),((Byte)model.getStatus()).toString()}, model.GetModel.toString());  
	return a;
}
public int Edit (ModelUser model)throws ClassNotFoundException, SQLException {
	
	int a;
	a=cr.Update(new String [] {ModelUser.GetUsername,ModelUser.GetPassword,ModelUser.GetStatus},new String [] {model.getUserName().toString(),model.getPassword().toString(),((Byte)model.getStatus()).toString()}, model.GetModel.toString(),ModelUser.GetUserId.toString(),String.valueOf(model.getUserId()));  
	return a;
}
public int Delete (ModelUser model)throws ClassNotFoundException, SQLException {

	int a;
	a=cr.Delete(model.GetModel,model.GetUserId ,String.valueOf(model.getUserId()));
	return a;
}
}
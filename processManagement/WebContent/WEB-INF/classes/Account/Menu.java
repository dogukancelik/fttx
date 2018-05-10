package Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBContext.CRUD;

public class Menu {
	
	CRUD cr=new CRUD();
	public ArrayList<String[]> Menus(String UserId) throws ClassNotFoundException, SQLException{
			
	List lst=new ArrayList();
		
	return (ArrayList) cr.Query("Select ControllerId,ControllerName from controller where  SubControllerId='1' and ControllerId in  (Select ControllerId from rolecontroller where RoleId in (select RoleId from userrole where UserId='"+UserId +"'))");
		
		
	}
	
	public ArrayList<String[]> subMenu(String UserId,String ControllerId) throws ClassNotFoundException, SQLException{
		
		List lst=new ArrayList();
			
		return (ArrayList) cr.Query("Select ControllerId,ControllerName,ActionName from controller where ActionName not in ('edit','delete') and  SubControllerId='"+ControllerId+"' and ControllerId in  (Select ControllerId from rolecontroller where RoleId in (select RoleId from userrole where UserId='"+UserId +"'))");
			
			
		}

}

package Account;

import java.sql.SQLException;

import DBContext.CRUD;

public class Account {

	
public boolean IsAuthority(String cont,String act,String UserId) throws ClassNotFoundException, SQLException 
{
	CRUD cr=new CRUD();
	String sql="Select UserRoleId from userrole where UserId='"+UserId.toString()+"' and  RoleId in (Select RoleId from rolecontroller where ControllerId in( Select ControllerId from controller where ControllerName='"+cont.toString() +"' and ActionName='"+act.toString()+"'))";
	

	if((cr.Query(sql)).size()>0) {
		return true;}
	else {
		return false;
		

	
	
}
	
}}

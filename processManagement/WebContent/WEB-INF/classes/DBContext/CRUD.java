package DBContext;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CRUD   {
	public List GetListId(String[] prm,String model,String wherePrmt,String wherevalue) throws ClassNotFoundException, SQLException {
		String query="";
		String queryString;
		for(String pr:prm) {query += pr+",";}
		       queryString="Select "+query.substring(0, query.length()-1)+" from "+model.toString()+" where "+wherePrmt.toString()+"="+wherevalue.toString();
		       PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
				 ResultSet rs = psmt.executeQuery();
				List sbn=new ArrayList<String>();
					while(rs.next())
				 {
				 String [] str=new String[rs.getMetaData().getColumnCount()];
				 for (int i = 1; i < rs.getMetaData().getColumnCount()+1 ; i++) {
				 str[i-1]=rs.getString(i);
				 }
				 sbn.add(str);
				 }			
					dbContext.ConnectionClose();
					return sbn;
	   }
public List GetList(String[] prm,String model) throws ClassNotFoundException, SQLException {
	String query="";
	String queryString;
	for(String pr:prm) {query += pr+",";}
	       queryString="Select "+query.substring(0, query.length()-1)+" from "+model.toString();
	       PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
			 ResultSet rs = psmt.executeQuery();
			List sbn=new ArrayList<String>();
				while(rs.next())
			 {
			 String [] str=new String[rs.getMetaData().getColumnCount()];
			 for (int i = 1; i < rs.getMetaData().getColumnCount()+1 ; i++) {
			 str[i-1]=rs.getString(i);
			 }
			 sbn.add(str);
			 }			
				dbContext.ConnectionClose();
				return sbn;
   }
public int Create(String[] prm,String[] prm3,String model) throws SQLException, ClassNotFoundException{
	String query="";
	String queryString;
	String valu="";
	int i=0;
	for(String pr:prm)
	{
	query += pr+",";
	valu+="?,";
	}
	      queryString="INSERT INTO `"+model.toString()+"` ("+query.substring(0, query.length()-1)+") VALUE ("+valu.substring(0,	valu.length()-1)+")";
	     	 PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
			 for(String pr2:prm3)
				{
				i++;
				psmt.setString(i,pr2.toString());
				}
			 int rs =psmt.executeUpdate();
			  dbContext.ConnectionClose();
					return rs;
}
public int Update(String[] prm,String[] prm3,String model,String valuesPrm, String values) throws ClassNotFoundException, SQLException {
    String query="";
	String queryString;
	int i=0;
	for(String pr:prm)
	{
	query +=pr+" = ?,";
	}
	queryString="UPDATE "+model.toString()+" SET "+query.substring(0, query.length()-1)+" WHERE "+valuesPrm.toString()+"=?";
	       PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
			 for(String pr2:prm3)
				{
				i++;
				psmt.setString(i,pr2.toString());
				}
			 psmt.setString(i+1,values.toString());
			 int rs =psmt.executeUpdate();
			  dbContext.ConnectionClose();
					return rs;
  }
public int Delete(String model,String valuesPrm,String value) throws SQLException, ClassNotFoundException {
	
	String queryString = "DELETE FROM "+model.toString()+ " where "+valuesPrm.toString() +"= ?";
	  PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
	 psmt.setString(1,value);
	 int rs =psmt.executeUpdate();
	 dbContext.ConnectionClose();
	return rs;
	}
	

}

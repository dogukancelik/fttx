package DBContext;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import com.oracle.tools.packager.RelativeFileSet.Type;
import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CRUD   {

private List<String> ls=new ArrayList<>();
private List lst=new ArrayList<>();

public List GetList(String[] prm) throws ClassNotFoundException, SQLException {
	 
	String query="";
	String queryString;
	for(String pr:prm) {query += pr+",";}
	       queryString="Select "+query.substring(0, query.length()-1)+" from users";
	       System.out.println(queryString);
			 PreparedStatement psmt = (PreparedStatement) dbContext.ConnectionOpen().prepareStatement(queryString);
			 ResultSet rs = psmt.executeQuery();
		
			List sbn=new ArrayList<String>();
			
			 int k=0;
			 while(rs.next())
			 {k++;
			 String [] str=new String[rs.getMetaData().getColumnCount()-1];
			 for (int i = 1; i < rs.getMetaData().getColumnCount() ; i++) {
			 str[i-1]=rs.getString(i);
			 }
				
				 sbn.add(str);
			     
				 
		 	
		 	
		 	
		 		
		 		
		 	/*System.out.print(rs.getString(1));
		 	System.out.print(rs.getString(2));
		 	System.out.print(rs.getString(3));
		 	System.out.print(rs.getString(4));
		 	System.out.println();
		 	setA.add(rs.getString(1));
		 	setA.add(rs.getString(2));*/
		 	
		
	}
			
			 		
				return sbn;
   
}
public int Create(){return 1;}
public int Edit() {return 1;}
public int Delete() {return 1;}
	

}

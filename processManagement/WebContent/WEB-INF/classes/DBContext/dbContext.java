package DBContext;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbContext {
	
	public dbContext () throws SQLException, ClassNotFoundException {
		String Host = "jdbc:mysql://localhost:3306/menu"; 
		//String dbName = "menu";
		String Username = "root";
		String Password = "";
		
		Class.forName("com.mysql.jdbc.Connection");
		Connection con =(Connection)DriverManager.getConnection(Host, Username, Password);	
		
		String query = "Select * from allmenu";
		 PreparedStatement psmt = (PreparedStatement) con.prepareStatement(query);
		 ResultSet rs = psmt.executeQuery();
		
		 while(rs.next()) {
			 System.out.println(rs.getString(1));
		 }
	}
	

}

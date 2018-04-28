package DBContext;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;

public  class dbContext {
	
	private static java.sql.Connection con;
	public static void ConnectionOpen() throws SQLException, ClassNotFoundException {
		String Host = "jdbc:mysql://localhost:3306/"; 
		String dbName = "menu";
		String Username = "root";
		String Password = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		 con =DriverManager.getConnection(Host + dbName, Username, Password);	
		
		/*String query = "Select * from allmenu";
		 PreparedStatement psmt = (PreparedStatement) con.prepareStatement(query);
		 ResultSet rs = psmt.executeQuery();
		 while(rs.next()) {
			 System.out.println(rs.getString(1));
		 }*/
		
	}
	public static void ConnectionClose() throws SQLException, ClassNotFoundException {
		
		con.close();
	}
	

}

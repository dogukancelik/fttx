package DBContext;


import java.sql.DriverManager;
import java.sql.SQLException;

public  class dbContext {
	
	private static int connectionStatus ;
	private static java.sql.Connection con;
	
	private static void Close()  throws SQLException, ClassNotFoundException { con.close(); connectionStatus=0; }
	private static java.sql.Connection  Open() throws SQLException, ClassNotFoundException
	{
		String Host = "jdbc:mysql://localhost:3306/"; 
		String dbName = "processmanagement";
		String Username = "root";
		String Password = "root";
		Class.forName("com.mysql.jdbc.Driver");
		 con =DriverManager.getConnection(Host + dbName, Username, Password);
		connectionStatus=1;
  return con;
	}
		
	public static java.sql.Connection ConnectionOpen() throws SQLException, ClassNotFoundException {
		
		if(connectionStatus==0) {		
			 Open();
			return con;
			}
		else
			{
			Close();
			Open();
			return con;
		}
	}
	
	public static void ConnectionClose() throws SQLException, ClassNotFoundException {
		
		if(connectionStatus==1) {		
			Close();
		}
	}
	
	

}

package DBContext;

import java.io.IOException;
import java.util.Set;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.ModelUser;
import DAL.USER;
@WebServlet("/DataBase")
public class DataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DataBase() {
        super();
      }
@SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//response.getWriter().append("Served at: ").append(request.getContextPath());
		USER user=new USER();
		try {
			for(ModelUser st:user.getUserList()) 
			{
			   System.out.print(st.getUserId()+" ");
			   System.out.print(st.getUserName()+" ");
			   System.out.print(st.getPassword()+" ");
			   System.out.print(st.getStatus());
			   System.out.println();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
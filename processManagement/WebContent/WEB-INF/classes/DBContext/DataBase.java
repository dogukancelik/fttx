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
import model.UserProfileModel;
import DAL.USERPROFILE;
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
		USERPROFILE  prf=new USERPROFILE();
		USER ur=new USER();
		int a=0;
		ModelUser us=new ModelUser();
		us.setUserId(3);
		us.setUserName("hami");	
		us.setPassword("1");
		us.setStatus(Byte.parseByte("0"));
		try {
			for(UserProfileModel s:prf.GetUserProfileList())
			{
				System.out.println(s.getUserId()+" "+s.getUserProfileId()+" "+s.getName()+" "+s.getSurName()+" "+s.getPhone()+" "+s.getMail()+" "+s.getAddress());
			}	
			
			for(ModelUser s1:ur.getUserList())
			{
				System.out.println(s1.getUserId()+" "+s1.getUserName()+" "+s1.getPassword()+" "+s1.getStatus());
				
			}
			try {
				a=user.Delete(us);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
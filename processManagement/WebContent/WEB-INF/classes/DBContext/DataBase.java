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
import javax.servlet.http.HttpSession;

import model.ModelUser;
import model.UserProfileModel;
import model.WorkDefinitionModel;
import DAL.USERPROFILE;
import DAL.WORKDEFINITION;
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
		UserProfileModel  prf1=new UserProfileModel();
		WORKDEFINITION  wr=new WORKDEFINITION();
		WorkDefinitionModel wrk=new WorkDefinitionModel();
		int a=0;
		ModelUser us=new ModelUser();
		
		 HttpSession aa= request.getSession();
		
		
		try {
		
			
			wrk=wr.modeldoldur(request);
			System.out.println(wrk.getWorkDefinitionName());
			int dc=wr.Create(wrk);
			System.out.println(wrk);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*	try {
			for(UserProfileModel s:prf.GetUserProfileListId("surname","corakli"," and phone='111'"))
			{
				System.out.println(s.getUserId()+" "+s.getUserProfileId()+" "+s.getName()+" "+s.getSurName()+" "+s.getPhone()+" "+s.getMail()+" "+s.getAddress());
				prf1.setUserProfileId(s.getUserProfileId());
				prf1.setAddress(s.getAddress().toString());
				prf1.setMail(s.getMail().toString());
				prf1.setName("Hami");
				prf1.setPhone(s.getPhone().toString());
				prf1.setSurName(s.getSurName().toString());
				prf1.setUserId(s.getUserId());
			}	
			
			a=prf.Edit(prf1);
			
			for(UserProfileModel s1:prf.GetUserProfileList())
			{
				System.out.println(s1.getUserId()+" "+s1.getUserProfileId()+" "+s1.getName()+" "+s1.getSurName()+" "+s1.getPhone()+" "+s1.getMail()+" "+s1.getAddress());
				
			}	
			
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
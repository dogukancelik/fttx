package Filter;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAL.USER;
import model.ModelUser;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter(dispatcherTypes= {
		DispatcherType.REQUEST,
		DispatcherType.FORWARD,
		DispatcherType.INCLUDE}
,urlPatterns= {"/s","/index","/planing/index","/process/index","/processOrder/index","/processStep/index","/role/index","/roleProcess/index","/shared/layout_footer","/user/index","/userRole/index","/workDefinition/index",
		"/planing/create","/process/create","/processOrder/create","/processStep/create","/role/create","/roleProcess/create","/shared/layout_header","/user/create","/userRole/create","/workDefinition/create",
		"/planing/edit","/process/edit","/processOrder/edit","/processStep/edit","/role/edit","/roleProcess/edit","/shared/secure","/user/edit","/userRole/edit","/workDefinition/edit",
		"/planing/delete","/process/delete","/processOrder/delete","/processStep/delete","/role/delete","/roleProcess/delete","/shared/","/user/delete","/userRole/delete","/workDefinition/delete"

})
public class Authentication implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("null")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		String kullaniciAdi= (String)((HttpServletRequest)request).getParameter("username");
		String password= (String)((HttpServletRequest)request).getParameter("password");
		USER us=new USER();
		ModelUser mus=new ModelUser();
		final HttpSession session = ((HttpServletRequest) request).getSession();
			if(((HttpServletRequest)request).getSession().getAttribute("UserId")!= null){
			chain.doFilter(request, response);
		}
			else
				{
					try
					{
						if(kullaniciAdi!=null && password!=null )	
							{
									if(us.getUserListId("username",kullaniciAdi.toString()," and password='"+password.toString()+"'").size()>0) 
									{ 
										session.setAttribute("UserId", mus.getUserId());
										session.setMaxInactiveInterval(60*2);
										((HttpServletResponse)response).sendRedirect("/processManagement/index");
									}	 
										else
											{
												((HttpServletResponse)response).sendRedirect("/processManagement/login");
											}
							 }
								else
									{ ((HttpServletResponse)response).sendRedirect("/processManagement/login"); }
					}
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

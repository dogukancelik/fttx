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
import javax.servlet.http.HttpSession;

import DAL.CONTROLLER;
import DAL.ROLECONTROLLER;
import DAL.USERROLE;
import model.ControllerModel;
import model.ModelUser;
import model.RoleControllerModel;
import model.UserRoleModel;

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, 
		urlPatterns = { 
				""
				
		})
public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {
        // TODO Auto-generated constructor stub
    	
    	 
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
/*		final HttpSession session = ((HttpServletRequest) request).getSession();
		String controllerName;
		String actionname;
		String UserId;
		ModelUser mode=new ModelUser();
		
		System.out.println(mode.getUserName());
if(!((HttpServletRequest)request).getRequestURI().equals("/processManagement/login")) {
	
	if	(request.getParameter("controllerName")!=null) {
		controllerName=request.getParameter("controllerName").toString();
		actionname=request.getParameter("controllerName").toString();
		UserId="1";
		}else {
			
			controllerName="Home";
			actionname="index";
			UserId="1";
		}
		 USERROLE userrole=new USERROLE();
		 ROLECONTROLLER rocont=new ROLECONTROLLER();
		 CONTROLLER controller= new CONTROLLER();
		 ControllerModel contmodel=new ControllerModel();
		 RoleControllerModel rolcontrmodel=new  RoleControllerModel();
         UserRoleModel usermodel=new UserRoleModel();
         
        UserId=((HttpServletRequest)request).getSession().getAttribute("UserId").toString();
			
		try {
		String contID=String.valueOf(controller.GetcontrolList(contmodel.GetControllerName,controllerName,"ActionName='"+actionname+"'").get(0).getControllerId());
		String RoleID=String.valueOf(userrole.GetRoleList(usermodel.GetRoleId, UserId).get(0).getUserRoleId());
		System.out.println(rocont.GetcontrolList(rolcontrmodel.GetControllerId,contID," and RoleId "+ RoleID).get(0).getControlerId());
		if(	rocont.GetcontrolList(rolcontrmodel.GetControllerId,contID," and RoleId=' "+ RoleID+"'").get(0).getControlerId()!=0)
		{
			chain.doFilter(request, response);
			
		} else {
			((HttpServletResponse)response).sendRedirect("/processManagement/index");
			
		}
		
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}else { chain.doFilter(request, response); }*/
	
		// pass the request along the filter chain
		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

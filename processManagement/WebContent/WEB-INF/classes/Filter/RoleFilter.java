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

import Account.Account;
import DAL.CONTROLLER;
import DAL.ROLECONTROLLER;
import DAL.USERROLE;
import model.ControllerModel;
import model.ModelUser;
import model.RoleControllerModel;
import model.UserRoleModel;
import javax.servlet.http.HttpSession;
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
					urlPatterns= {"/s","/planning/index","/process/index","/processOrder/index","/processStep/index","/role/index","/roleProcess/index","/shared/layout_footer","/user/index","/userRole/index","/workDefinition/index",
							"/planning/create","/process/create","/processOrder/create","/processStep/create","/role/create","/roleProcess/create","/shared/layout_header","/user/create","/userRole/create","/workDefinition/create",
							"/planning/edit","/process/edit","/processOrder/edit","/processStep/edit","/role/edit","/roleProcess/edit","/shared/secure","/user/edit","/userRole/edit","/workDefinition/edit",
							"/planning/delete","/process/delete","/processOrder/delete","/processStep/delete","/role/delete","/roleProcess/delete","/shared/","/user/delete","/userRole/delete","/workDefinition/delete"
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

	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	Account ac=new Account();
	final HttpSession session = ((HttpServletRequest) request).getSession();

	String [] url=((HttpServletRequest)request).getRequestURI().split("/");
	String controller=url[url.length-2];
	String action=url[url.length-1];
	String UserId=session.getAttribute("UserId").toString();
	
	
	if(!controller.equals("processManagement")) {
	  
		
		boolean as;
		
		try {
			as = ac.IsAuthority(controller, action,UserId);
			//System.out.println(controller+" "+action+" "+UserId);
		
			if (as==true) {
				
				
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
		
	}else {
		if(!action.equals("index") )
		{ ((HttpServletResponse)response).sendRedirect("/processManagement/"+action+"/index"); }else {
		chain.doFilter(request, response); }}
    
	
	
	
	
		
		
		//System.out.println(query);
		
		//String[] controller=query.split(",");
		
		//System.out.println(controller[0].toString());
		//System.out.println(controller[1].toString());
		
		
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

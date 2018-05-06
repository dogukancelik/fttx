package Filter;


import java.io.IOException;

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



/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter(dispatcherTypes= {
		DispatcherType.REQUEST,
		DispatcherType.FORWARD,
		DispatcherType.INCLUDE}
,urlPatterns= {"/*"})
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(!((HttpServletRequest)request).getRequestURI().equals("/processManagement/login")) {
			
			System.out.println(((HttpServletRequest)request).getRequestURI());
			
			
		}else {chain.doFilter(request, response);}
		
         if( ((HttpServletRequest)request).getSession().getAttribute("UserId") == null){
        	 
        	 System.out.println("sami");
				((HttpServletResponse)response).sendRedirect("/processManagement/login");
			
			// pass the request along the filter chain
				}else {chain.doFilter(request, response);}
			
		}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

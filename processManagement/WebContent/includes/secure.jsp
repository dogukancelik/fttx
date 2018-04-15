<%
if(session.getAttribute("UserId") != null){
	response.sendRedirect("login");
}
%>
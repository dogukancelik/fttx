<%@page import="javax.servlet.http.HttpSession" %>

<%
session.setAttribute("UserId","1");
session.setMaxInactiveInterval(60);

%>
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

USER user = new USER();
ModelUser u = new ModelUser();
for(ModelUser st:user.getUserListId("userId", ID)) 
{
	u.setUserId(st.getUserId());
	u.setUserName(st.getUserName());
	u.setPassword(st.getPassword());
	u.setStatus(st.getStatus());
}
%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Users Delete</div>
		<h2>Do you want to delete this user ?</h2>
		<div>User ID: <b><%=u.getUserId() %></b></div>
		<div>User Name: <b><%=u.getUserName()%></b></div>
		<div>User Password: <b><%=u.getPassword() %></b></div>
		<div>User Status: <b><%=u.getStatus() %></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="user/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
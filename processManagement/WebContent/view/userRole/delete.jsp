<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.UserRoleModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];


UserRoleModel urm = new UserRoleModel();


%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-users"></i> User Role Delete</div>
		<h2>Do you want to delete this user role ?</h2>
		<div>User Role ID: <b><%=urm.getUserRoleId() %></b></div>
		<div>Role ID: <b><%=urm.getRoleId()%></b></div>
		<div>User ID: <b><%=urm.getUserId() %></b></div>
		<div>Description: <b><%=urm.getUserRoleDescription() %></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="userRole/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="USERROLE,delete">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
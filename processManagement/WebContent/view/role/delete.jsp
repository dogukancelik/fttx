<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

RoleModel rm = new RoleModel();

%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-gg-circle"></i> Role Delete</div>
		<h2>Do you want to delete this role ?</h2>
		<div>Role ID: <b><%=rm.getRoleId() %></b></div>
		<div>Role Name: <b><%=rm.getRoleName()%></b></div>
		<div>Description: <b><%=rm.getRoleDescription()%></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="role/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="role,delete">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
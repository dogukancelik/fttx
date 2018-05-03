<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleProcessModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

RoleProcessModel rpm = new RoleProcessModel();
%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-cubes"></i> Role Process Delete</div>
		<h2>Do you want to delete this role process ?</h2>
		<div>Role Process ID: <b><%=rpm.getRolePocessId() %></b></div>
		<div>Process ID: <b><%=rpm.getProcessId()%></b></div>
		<div>Role ID: <b><%=rpm.getRoleId()%></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="roleProcess/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
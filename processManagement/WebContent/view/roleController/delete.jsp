<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleControllerModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

RoleControllerModel rcm = new RoleControllerModel();

%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-link"></i> Role Controller Delete</div>
		<h2>Do you want to delete this role controller ?</h2>
		<div>Role Controller ID: <b><%=rcm.getRoleControllerId() %></b></div>
		<div>Role ID: <b><%=rcm.getRoleId()%></b></div>
		<div>Controller ID: <b><%=rcm.getControlerId()%></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="roleController/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="roleController,delete">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
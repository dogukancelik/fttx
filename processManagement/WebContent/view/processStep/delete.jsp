<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessStepModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];


ProcessStepModel pm = new ProcessStepModel();
%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-step-forward"></i> Process Step Delete</div>
		<h2>Do you want to delete this Process Step ?</h2>
		<div>Process Step ID: <b><%=pm.getProcessStepId() %></b></div>
		<div>Process Step Date: <b><%=pm.getProcessDate()%></b></div>
		<div>User ID: <b><%=pm.getUserId() %></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="processStep/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="processStep,delete">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
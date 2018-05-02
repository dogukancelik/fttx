<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessOrderModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

ProcessOrderModel st = new ProcessOrderModel();


%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Process Order Delete</div>
		<h2>Do you want to delete this process order ?</h2>
		<div>Process Order ID: <b><%=st.getProcessOrderId() %></b></div>
		<div>Process Order: <b><%=st.getProcessOrder()%></b></div>
		<div>Process ID: <b><%=st.getProcessId()%></b></div>
		<div>Work Definition: <b><%=st.getWorkDefinitionId()%></b></div>
		<div>Order: <b><%=st.getOrder() %></b></div>
		
		<form action="#" method="post">
		<div style="height:75px; line-height:75px">
			<a href="processOrder/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessOrderModel, DAL.PROCESSORDER"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

PROCESSORDER po = new PROCESSORDER();
ProcessOrderModel u = new ProcessOrderModel();
for(ProcessOrderModel st: po.GetProcessOrderList("ProcessOrderId", ID)){
	u.setProcessOrderId(st.getProcessOrderId());
	u.setProcessId(st.getProcessId());
	u.setProcessOrder(st.getProcessOrder());
	u.setWorkDefinitionId(st.getWorkDefinitionId());
	u.setProcessCheck(st.getProcessCheck());
}


%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-sort"></i> Process Order Delete</div>
		<h2>Do you want to delete this process order ?</h2>
		<div>Process Order ID: <b><%=u.getProcessOrderId() %></b></div>
		<div>Process Order: <b><%=u.getProcessOrder()%></b></div>
		<div>Process ID: <b><%=u.getProcessId()%></b></div>
		<div>Work Definition: <b><%=u.getWorkDefinitionId()%></b></div>
		<div>Order: <b><%=u.getProcessCheck() %></b></div>
		
		<form action="dataBase" method="post">
		<div style="height:75px; line-height:75px">
			<a href="processOrder/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="processOrder,delete">
			<input type="hidden" name="ProcessOrderId" value="<%=ID%>">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
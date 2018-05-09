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
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-sort"></i> Process Order Edit</div>
		<form action="dataBase" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process ID: </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="ProcessId">
							<%
								
								for(ProcessOrderModel st2: po.GetProcessOrderList()){
							%>
							<option><%=st2.getProcessId()%></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr><td><div id="ProcessIdVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Work Definition: </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="WorkDefinitionId">
							<%
								
								for(ProcessOrderModel st2: po.GetProcessOrderList()){
							%>
							<option><%=st2.getWorkDefinitionId()%></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr><td><div id="WorkDefinitionIdVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Process Order ID: </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="ProcessOrder">
							<%
								
								for(ProcessOrderModel st2: po.GetProcessOrderList()){
							%>
							<option><%=st2.getProcessOrder()%></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr><td><div id="ProcessOrderVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Process Check: </td>
				</tr>
				<tr>
					<td><input type="checkbox" name="ProcessCheck" checked="<%=u.getProcessCheck()%>"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="processOrder/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="processOrder,edit">
						<input type="hidden" name="ProcessOrderId" value="<%=ID%>">
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>html>
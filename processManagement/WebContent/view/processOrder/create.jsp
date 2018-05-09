<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessOrderModel,model.ProcessModel,model.WorkDefinitionModel , DAL.PROCESSORDER, DAL.PROCESS,DAL.WORKDEFINITION"  %>

<%
PROCESSORDER po = new PROCESSORDER();
PROCESS process=new PROCESS();
WORKDEFINITION wrk=new WORKDEFINITION();
ProcessOrderModel u = new ProcessOrderModel();
for(ProcessOrderModel st: po.GetProcessOrderList()){
	u.setProcessOrderId(st.getProcessOrderId());
	u.setProcessId(st.getProcessId());
	u.setProcessOrder(st.getProcessOrder());
	u.setWorkDefinitionId(st.getWorkDefinitionId());
	u.setProcessCheck(st.getProcessCheck());
}

%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-sort"></i> Process Order Create</div>
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
								
								for(ProcessModel st2: process.GetProcessList()){
							%>
							<option value="<%=st2.getProcessId()%>"><%=st2.getProcessName()%>
							 
							</option>
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
								for(WorkDefinitionModel st: wrk.GetDefinitionList()){
							%>
							<option value="<%=st.getWorkDefinitionId()%>"><%=st.getWorkDefinitionName()%></option>
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
					<select name="<%=ProcessOrderModel.GetOrder%>" class="select1">
						<%
							for(ProcessOrderModel mm: po.GetProcessOrderList()){
						%>
						<option value="<%=mm.getProcessOrderId()%>"><%=mm.getProcessOrder() %></option>
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
						<input type="hidden" name="actions" value="processOrder,create">
												<input type="hidden" name=<%=u.GetProcessOrderId %> value=<%=u.getProcessOrderId() %>>
												<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
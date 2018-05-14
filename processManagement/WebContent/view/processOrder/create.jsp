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
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-sort"></i> Process Order Create</div>
		<form action="dataBase" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:770px;">
			<tbody>
				<tr>
					<td class="label1" colspan="3">Work Definition: </td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3">
						<select class="select1" name="WorkDefinitionId">
							<%
								for(WorkDefinitionModel st: wrk.GetDefinitionList()){
							%>
							<option value="<%=st.getWorkDefinitionId()%>"><%=st.getWorkDefinitionName()%></option>
							<%} %>
						</select>
					</td>
					<td></td>
				</tr>
				<tr><td colspan="3"><div id="WorkDefinitionIdVal" class="validator"></div></td><td></td></tr>
				
				<tr>
					<td colspan="3" class="label1">Process ID: </td>
					<td></td>
				</tr>
				<tr>
					<td width="252">
						<select class="selectMultiple1" name="selectFrom" multiple="multiple" size="15">
							<%
								for(ProcessModel st2: process.GetProcessList()){
							%>
		                    <option value="<%=st2.getProcessId()%>"><%=st2.getProcessName()%>
		                    <%
								}
		                    %>
	                	</select>
					</td>
					
					<td width="136" align="center">
            			<input type="button" value=" Seçilenleri Ekle >> " onclick="selectAdd('selectFrom', 'ProcessOrder')"/>
                		<input type="button" value=" << Seçilenleri Sil &nbsp;&nbsp;&nbsp;" onclick="selectRemove('selectFrom', 'ProcessOrder')"/>
            		</td>
					<td width="252" align="right">
						<select class="selectMultiple1" name="ProcessOrder" size="15"></select>
					</td>
					<td align="center">
						<div class="verticalButton" onclick="selectOrder(-1, 'ProcessOrder')"><i class="fa fa-arrow-up"></i></div><br>
						<div class="verticalButton"><i class="fa fa-arrow-down" onclick="selectOrder(+1, 'ProcessOrder')"></i></div>
					</td>
				</tr>
				
				<!--  
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
					<td class="label1">Process Order ID: </td>
				</tr>
				<tr>
					<td><input type="text" name="ProcessOrder" class="input1"/></td>
				</tr>
				<tr><td><div id="ProcessOrderVal" class="validator"></div></td></tr>
				-->
				
				<tr>
					<td colspan="3" class="label1">Process Check: </td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3"><input type="checkbox" name="ProcessCheck" checked="<%=u.getProcessCheck()%>"/></td>
					<td></td>
				</tr>					
				
				<tr height="75"> 
					<td colspan="4">
						<a href="processOrder/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="processOrder,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
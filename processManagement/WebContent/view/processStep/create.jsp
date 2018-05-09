<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessStepModel, DAL.PROCESSSTEP"  %>
<%@ page import="model.ProcessStepModel, DAL.PROCESS"  %>

<%
	PROCESSSTEP ps = new PROCESSSTEP();
%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-step-forward"></i> Process Step Create</div>
		<form action="dataBase" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process : </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="ProcessId">
							<%for(ProcessStepModel st: ps.GetProcessOrderList()){ %>
							<option value="<%=st.getProcessId() %>"><%=st.getProcessId() %></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr><td><div id="ProcessIdVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">User : </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="UserId">
						<%for(ProcessStepModel st: ps.GetProcessOrderList()){ %>
							<option value="<%=st.getUserId() %>"><%=st.getUserId() %></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr><td><div id="UserIdVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Date: </td>
				</tr>
				<tr>
					<td><input type="date" name="ProcessDate" class="input1"/></td>
				</tr>
				<tr><td><div id="ProcessDateVal" class="validator"></div></td></tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="processStep/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="processStep,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
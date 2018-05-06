<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessModel"  %>

<% 
	ProcessModel st = new ProcessModel();
%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-tasks"></i> Process Edit</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="processName" value="<%=st.getProcessName()%>" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">Process Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="description" value="<%=st.getProcessDescription()%>" class="input1"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="process/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden"name="actions" value="PROCESS,edit">
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
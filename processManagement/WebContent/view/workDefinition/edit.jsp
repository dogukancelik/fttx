<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.WorkDefinitionModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

WorkDefinitionModel wdm = new WorkDefinitionModel();
%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-th"></i> Work Definiton Edit</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Definiton Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="definitonname" class="input1" value="<%=wdm.getWorkDefinitionName()%>"/></td>
				</tr>
				
				<tr>
					<td class="label1">Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="description" class="input1" value="<%=wdm.getWorkDefinitionDesciription()%>"/></td>
				</tr>
							
				
				<tr height="75"> 
					<td colspan="2">
						<a href="workDefinition/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="WORKDEFINITION,edit">
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
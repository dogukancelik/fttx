<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

RoleModel rm = new RoleModel();


%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-gg-circle"></i> Role Edit</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Role Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="rolename" value="<%=rm.getRoleName()%>" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="description" value="<%=rm.getRoleDescription() %>" class="input1"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="role/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
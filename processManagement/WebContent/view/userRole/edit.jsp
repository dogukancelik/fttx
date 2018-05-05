<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.UserRoleModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

UserRoleModel urm = new UserRoleModel();

%>



<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-users"></i> User Role Edit</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Role ID: </td>
				</tr>
				<tr>
					<td><select name="roleid" class="select1"><option>select</option></select></td>
				</tr>
				
				<tr>
					<td class="label1">User ID: </td>
				</tr>
				<tr>
					<td><select name="userid" class="select1"><option>select</option></select></td>
				</tr>
				
				<tr>
					<td class="label1">Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="description" class="input1" value="<%=urm.getUserRoleDescription()%>"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="userRole/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
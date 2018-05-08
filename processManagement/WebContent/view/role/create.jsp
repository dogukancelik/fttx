<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleModel"  %>

<%
	RoleModel rm = new RoleModel();
%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-gg-circle"></i> Role Create</div>
		<form action="#" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Role Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="RoleName" class="input1"/></td>
				</tr>
				<tr><td><div id="RoleNameVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="RoleDescription" class="input1"/></td>
				</tr>	
				<tr><td><div id="RoleDescriptionVal" class="validator"></div></td></tr>		
				
				<tr height="75"> 
					<td colspan="2">
						<a href="role/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="role,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
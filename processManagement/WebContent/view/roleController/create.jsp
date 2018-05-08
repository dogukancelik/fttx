<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleControllerModel"  %>

<%
	RoleControllerModel rcm = new RoleControllerModel();
%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-link"></i> Role Controller Create</div>
		<form action="#" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Role ID: </td>
				</tr>
				<tr>
					<td><select name="RoleId" class="select1"><option>select</option></select></td>
				</tr>
				<tr><td><div id="RoleIdVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Controller ID: </td>
				</tr>
				<tr>
					<td><select name="RoleController" class="select1"><option>select</option></select></td>
				</tr>	
				<tr><td><div id="RoleControllerVal" class="validator"></div></td></tr>		
				
				<tr height="75"> 
					<td colspan="2">
						<a href="roleController/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="roleController,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
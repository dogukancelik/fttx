<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleProcessModel"  %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-cubes"></i> Role Process Create</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process ID: </td>
				</tr>
				<tr>
					<td><select name="processid" class="select1"><option>select</option></select></td>
				</tr>
				
				<tr>
					<td class="label1">Role ID: </td>
				</tr>
				<tr>
					<td><select name="roleid" class="select1"><option>select</option></select></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="roleProcess/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
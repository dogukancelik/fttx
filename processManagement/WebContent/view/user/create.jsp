<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser"  %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-user-circle"></i> Users Create</div>
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">UserName: </td>
				</tr>
				<tr>
					<td><input type="text" name="username" class="input1"/></td>
				</tr>
				<tr><td><div id="usernameVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Password: </td>
				</tr>
				<tr>
					<td><input type="text" name="password" class="input1"/></td>
				</tr>
				<tr><td><div id="passwordVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Status: </td>
				</tr>
				<tr>
					<td><input type="checkbox" name="status" /></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="user/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="USER,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
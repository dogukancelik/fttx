<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<div class="content">
	<%
	String action = request.getParameter("action");
	if(action == null){
	%>
	<%// @page import=""%>
	<div class="contentItem">
		<div class="head"><i class="fa fa-user-circle"></i> My Account</div>
		<table style="margin:15px;">
			<tbody>
				<tr>
					<td width="50%" class="label1">Name: </td>
					<td class="label1">Surname: </td>
				</tr>
				<tr>
					<td width="50%"><input type="text" name="name" class="input1"/></td>
					<td><input type="text" name="surname" class="input1"/></td>
				</tr>
				<tr>
					<td width="50%"><div id="valName" class="validator"></div></td>
					<td><div id="valSurname" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">Mail: </td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="mail" class="input1"/></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valMail" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">Phone: </td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="phone" class="input1"/></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valPhone" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">Address: </td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="address" class="input1"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valAddress" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">Password: </td>
				</tr>
				<tr>
					<td colspan="2"><a href="?action=passwordChange" class="a1">Change My Password</a></td>
				</tr>
				
				<tr height="75">
					<td colspan="2"><input type="submit" value="Update" class="button1"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<%
	}
	else if(action.equals("passwordChange")){
	%>
	<div class="contentItem">
		<div class="head"><i class="fa fa-user-circle"></i> Change My Password</div>
		<table style="margin:15px; width:300px">
			<tbody>
				<tr>
					<td colspan="2" class="label1">Old Password: </td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="oldpassword" class="input1"/></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valOldPassword" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">New Password: </td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="newPassword" class="input1"/></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valNewPassword" class="validator"></div></td>
				</tr>
				
				<tr>
					<td colspan="2" class="label1">New Password (Again): </td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="newPassword2" class="input1"/></td>
				</tr>
				<tr>
					<td colspan="2"><div id="valNewPassword2" class="validator"></div></td>
				</tr>
				
				<tr height="75">
					<td colspan="2">
						<a href="myAccount" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a> 
						<input type="submit" value="Change" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<%} %>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
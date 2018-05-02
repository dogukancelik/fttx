<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

USER user = new USER();
ModelUser u = new ModelUser();
for(ModelUser st:user.getUserListId("userId", ID)) 
{
	u.setUserId(st.getUserId());
	u.setUserName(st.getUserName());
	u.setPassword(st.getPassword());
	u.setStatus(st.getStatus());
}


%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-user-circle"></i> Users Edit</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">UserName: </td>
				</tr>
				<tr>
					<td><input type="text" name="username" value="<%=u.getUserName()%>" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">Password: </td>
				</tr>
				<tr>
					<td><input type="text" name="password" value="<%=u.getPassword() %>" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">Status: </td>
				</tr>
				<tr>
					<td><input type="checkbox" name="status" checked="<%=u.getStatus()%>"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="user/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
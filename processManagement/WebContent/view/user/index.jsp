<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Users List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="user/create">Create New User</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>UserName</th>
		            <th>Password</th>
		            <th>Status</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>UserName</th>
		            <th>Password</th>
		            <th>Status</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	USER user=new USER();
				for(ModelUser st:user.getUserList()) 
				{
		    %>
		        <tr align="center">
		            <td><%=st.getUserId() %></td>
		            <td><%=st.getUserName()%></td>
		            <td><%=st.getPassword()%> </td>
		            <td><%=st.getStatus() %></td>
		            <td>
		            	<a class="a1" href="user/edit/<%=st.getUserId() %>">Edit</a> |
		            	<a class="a1" href="user/delete/<%=st.getUserId() %>">Delete</a>
		            </td>
		        </tr>
		    <%} %>
		    </tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="js/jqueryDataTable.js"></script>
<script type="text/javascript" src="js/jquery-uiDataTable.js"></script>
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
} );
</script>

<%@ include file="/view/shared/layout_footer.jsp" %>
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.UserRoleModel"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-users"></i> User Role List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="userRole/create">Create New User Role</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Role ID</th>
		            <th>User ID</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Role ID</th>
		            <th>User ID</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	UserRoleModel urm = new UserRoleModel();
		    %>
		        <tr align="center">
		            <td><%=urm.getUserRoleId() %></td>
		            <td><%=urm.getRoleId()%></td>
		            <td><%=urm.getUserId()%> </td>
		            <td><%=urm.getUserRoleDescription() %></td>
		            <td>
		            	<a class="a1" href="userRole/edit/<%=urm.getUserRoleId() %>">Edit</a> |
		            	<a class="a1" href="userRole/delete/<%=urm.getUserRoleId() %>">Delete</a>
		            </td>
		        </tr>
		    <% %>
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
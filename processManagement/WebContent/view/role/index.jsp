<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleModel"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-gg-circle"></i> Role List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="role/create">Create New Role</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Role Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Role Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	RoleModel rm = new RoleModel();
		    %>
		        <tr align="center">
		            <td><%=rm.getRoleId() %></td>
		            <td><%=rm.getRoleName()%></td>
		            <td><%=rm.getRoleDescription()%> </td>
		            <td>
		            	<a class="a1" href="role/edit/<%=rm.getRoleId() %>">Edit</a> |
		            	<a class="a1" href="role/delete/<%=rm.getRoleId() %>">Delete</a>
		            </td>
		        </tr>
		    <%%>
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
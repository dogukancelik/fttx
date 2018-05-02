<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessModel"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-tasks"></i> Process List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="process/create">Create New Process</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Process Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Process Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
				ProcessModel st = new ProcessModel();
		    %>
		        <tr align="center">
		            <td><%=st.getProcessId() %></td>
		            <td><%=st.getProcessName()%></td>
		            <td><%=st.getProcessDescription()%> </td>
		            <td>
		            	<a class="a1" href="process/edit/<%=st.getProcessId() %>">Edit</a> |
		            	<a class="a1" href="process/delete/<%=st.getProcessId() %>">Delete</a>
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
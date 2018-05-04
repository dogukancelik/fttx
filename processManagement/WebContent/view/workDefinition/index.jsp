<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.WorkDefinitionModel"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-th"></i> Work Definiton List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="workDefinition/create">Create New Work Definiton</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Definiton Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Definiton Name</th>
		            <th>Description</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    WorkDefinitionModel wdm = new WorkDefinitionModel();
		    %>
		        <tr align="center">
		            <td><%=wdm.getWorkDefinitionId() %></td>
		            <td><%=wdm.getWorkDefinitionName()%></td>
		            <td><%=wdm.getWorkDefinitionDesciription()%> </td>
		            <td>
		            	<a class="a1" href="workDefinition/edit/<%=wdm.getWorkDefinitionId() %>">Edit</a> |
		            	<a class="a1" href="workDefinition/delete/<%=wdm.getWorkDefinitionId() %>">Delete</a>
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
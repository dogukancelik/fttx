<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessStepModel"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">

<div class="content">
	<div class="contentItem" style="width:900px">
		<div class="head"><i class="fa fa-step-forward"></i> Process Step List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="processStep/create">Create New Process Step</a></div>
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Process Date</th>
		            <th>User ID</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Process Date</th>
		            <th>User ID</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    ProcessStepModel st = new ProcessStepModel();
		    %>
		        <tr align="center">
		            <td><%=st.getProcessStepId() %></td>
		            <td><%=st.getProcessDate()%></td>
		            <td><%=st.getUserId()%> </td>
		            <td>
		            	<a class="a1" href="processStep/edit/<%=st.getProcessStepId() %>">Edit</a> |
		            	<a class="a1" href="processStep/delete/<%=st.getProcessStepId() %>">Delete</a>
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
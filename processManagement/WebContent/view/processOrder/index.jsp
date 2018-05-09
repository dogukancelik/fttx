<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessOrderModel, DAL.PROCESSORDER"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:900px">
		<div class="head"><i class="fa fa-sort"></i> Process Order List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="processOrder/create">Create New Process Order</a></div>
		<div class="loading">
    		<i class="fa fa-refresh fa-spin"></i>
    			Data Loading...
    			
		</div>
		<br>
		<table id="table_id" style="display:none" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Process ID</th>
		            <th>Work Definiton ID</th>
		            <th>Process Order</th>
		            <th>Process Check</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Process ID</th>
		            <th>Work Definiton ID</th>
		            <th>Process Order</th>
		            <th>Process Check</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	PROCESSORDER po = new PROCESSORDER();
		    	for(ProcessOrderModel st: po.GetProcessOrderList()){
		    %>
		        <tr align="center">
		            <td><%=st.getProcessOrderId() %></td>
		            <td><%=st.getProcessId()%></td>
		            <td><%=st.getWorkDefinitionId()%> </td>
		            <td><%=st.getProcessOrder()%> </td>
		            <td><%=st.getProcessCheck() %></td>
		            <td>
		            	<a class="a1" href="processOrder/edit/<%=st.getProcessOrderId() %>">Edit</a> |
		            	<a class="a1" href="processOrder/delete/<%=st.getProcessOrderId() %>">Delete</a>
		            </td>
		        </tr>
		    <% }%>
		    </tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="js/jqueryDataTable.js"></script>
<script type="text/javascript" src="js/jquery-uiDataTable.js"></script>
<script>
$(document).ready( function () {
	setTimeout(function(){ 
		$("#table_id").show();
	    $(".loading").hide();
	    $('#table_id').DataTable();
	}, 1000);
	
} );
</script>

<%@ include file="/view/shared/layout_footer.jsp" %>
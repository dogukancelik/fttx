<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.RoleControllerModel, Account.Account"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-link"></i> Role Controller List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="roleController/create">Create New Role Controller</a></div>
		<div class="loading">
    		<i class="fa fa-refresh fa-spin"></i>
    			Data Loading...
    			
		</div>
		<br>
		<table id="table_id" style="display:none" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Role ID</th>
		            <th>Controller ID</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Role ID</th>
		            <th>Controller ID</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	RoleControllerModel rcm = new RoleControllerModel();
		    %>
		        <tr align="center">
		            <td><%=rcm.getRoleControllerId() %></td>
		            <td><%=rcm.getRoleId()%></td>
		            <td><%=rcm.getRoleControllerId()%> </td>
		            <td>
		            <% 
		            	Account ac=new Account(); 
		            
		            	if (ac.IsAuthority("roleController","edit", session.getAttribute("UserId").toString())){ 
		            %>
		            		<a class="a1" href="roleController/edit/<%=rcm.getRoleControllerId() %>">Edit</a>
		            <%	
		            	}
		            	if(ac.IsAuthority("roleController","edit", session.getAttribute("UserId").toString()) && ac.IsAuthority("roleController","delete", session.getAttribute("UserId").toString())){
		            %>
		            		|
		            <%
		            	} 
		            	if (ac.IsAuthority("roleController","delete", session.getAttribute("UserId").toString())){ 
		            %>
		            	<a class="a1" href="roleController/delete/<%=rcm.getRoleControllerId() %>">Delete</a>
		            <%
		            	} 
		            %>
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
	setTimeout(function(){ 
		$("#table_id").show();
	    $(".loading").hide();
	    $('#table_id').DataTable();
	}, 1000);
	
} );
</script>

<%@ include file="/view/shared/layout_footer.jsp" %>
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.CONTROLLER,model.ControllerModel, Account.Account "  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-yelp"></i> Controller List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="controller/create">Create New Controller</a></div>
		<div class="loading">
    		<i class="fa fa-refresh fa-spin"></i>
    			Data Loading...
    			
		</div>
		<br>
		<table id="table_id" style="display:none" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Sub ID</th>
		            <th>Controller Name</th>
		            <th>Action Name</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Sub ID</th>
		            <th>Controller Name</th>
		            <th>Action Name</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    	CONTROLLER c = new CONTROLLER();
				for(ControllerModel st: c.GetcontrolList()) 
				{
		    %>
		        <tr align="center">
		            <td><%=st.getControllerId() %></td>
		            <td><%=st.getSubControllerId()%></td>
		            <td><%=st.getControllerName()%> </td>
		            <td><%=st.getActionName() %></td>
		            <td>
		            <% 
		            	Account ac=new Account(); 
		            
		            	if (ac.IsAuthority("controler","edit", session.getAttribute("UserId").toString())){ 
		            %>
		            		<a class="a1" href="controler/edit/<%=st.getControllerId() %>">Edit</a> 
		            <%	
		            	}
		            	if(ac.IsAuthority("controler","edit", session.getAttribute("UserId").toString()) && ac.IsAuthority("controler","delete", session.getAttribute("UserId").toString())){
		            %>
		            		|
		            <%
		            	} 
		            	if (ac.IsAuthority("controler","delete", session.getAttribute("UserId").toString())){ 
		            %>
		            	<a class="a1" href="controler/delete/<%=st.getControllerId() %>">Delete</a>
		            <%
		            	} 
		            %>
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
	setTimeout(function(){ 
		$("#table_id").show();
	    $(".loading").hide();
	    $('#table_id').DataTable();
	}, 1000);
	
} );
</script>

<%@ include file="/view/shared/layout_footer.jsp" %>
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser, Account.Account "  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">


<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Users List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="user/create">Create New User</a></div>
		<div class="loading">
    		<i class="fa fa-refresh fa-spin"></i>
    			Data Loading...
    			
		</div>
		<br>
		<table id="table_id" style="display:none" class="display">
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
		            <% 
		            	Account ac=new Account(); 
		            
		            	if (ac.IsAuthority("user","edit", session.getAttribute("UserId").toString())){ 
		            %>
		            		<a class="a1" href="user/edit/<%=st.getUserId() %>">Edit</a> 
		            <%	
		            	}
		            	if(ac.IsAuthority("user","edit", session.getAttribute("UserId").toString()) && ac.IsAuthority("user","delete", session.getAttribute("UserId").toString())){
		            %>
		            		|
		            <%
		            	} 
		            	if (ac.IsAuthority("user","delete", session.getAttribute("UserId").toString())){ 
		            %>
		            	<a class="a1" href="user/delete/<%=st.getUserId() %>">Delete</a>
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
<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.WorkDefinitionModel, DAL.WORKDEFINITION, Account.Account, Account.Account"  %>

<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">

<div class="content">
	<div class="contentItem" style="width:1000px">
		<div class="head"><i class="fa fa-user-circle"></i> My Process List</div>
		<div class="loading">
    		<i class="fa fa-refresh fa-spin"></i>
    			Data Loading...
		</div>
		<table id="table_id" style="display:none" class="display">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Definiton Name</th>
		            <th>Description</th>
		            <th>Process ID</th>
		            <th>Process Name</th>
		            <th>Step</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>ID</th>
		            <th>Definiton Name</th>
		            <th>Description</th>
		            <th>Process ID</th>
		            <th>Process Name</th>
		            <th>Step</th>
		            <th></th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <% 
		    WORKDEFINITION wokdef=new WORKDEFINITION();
		    for(WorkDefinitionModel wdm:wokdef.GetDefinitionList() )
		    {
		    %>
		        <tr align="center">
		            <td><%=wdm.getWorkDefinitionId() %></td>
		            <td><%=wdm.getWorkDefinitionName()%></td>
		            <td><%=wdm.getWorkDefinitionDesciription()%></td>
		            <th></th>
		            <th></th>
		            <th></th>
		            <td>
		            	<a class="a1" href="#"><i class="fa fa-arrow-circle-left"></i> Back</a> | 
		            	<a class="a1" href="#">Next <i class="fa fa-arrow-circle-right"></i></a>
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
	    var table =  $('#table_id').DataTable();
	    table.column(3).visible(false);
	}, 1000);
	
} );
</script>
<%@ include file="/view/shared/layout_footer.jsp" %>
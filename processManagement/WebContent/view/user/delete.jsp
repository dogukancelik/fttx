<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DAL.USER,model.ModelUser"  %>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Users Delete</div>
		<h2>Do you want to delete this user ?</h2>
		<div>User ID: </div>
		<div>User Name: </div>
		<div>User Password: </div>
		
		<div style="height:75px; line-height:75px">
			<a href="user/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Delete" class="button1">
		</div>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
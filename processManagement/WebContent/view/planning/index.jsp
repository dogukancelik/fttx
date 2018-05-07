<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<link rel="stylesheet" href="css/calendar.css">
<div class="content">
	<div class="contentItem" style="width:730px">
		<div class="head"><i class="fa fa-calendar"></i> Planning List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="planning/create">Create New Planning</a></div>
		<div>
			<div id="calendar" style="margin:15px; float:right"></div>
		</div>
		
		<script>
		    var c = new calendar({
				id: "calendar",
				startDate: "Today",
				droppable: false,
				data: [
				]
			});
			
		</script>
		
		
	</div> 
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
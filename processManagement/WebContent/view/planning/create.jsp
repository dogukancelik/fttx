<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>
<script src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/dragableEvents.js"></script>
<link rel="stylesheet" href="css/calendar.css">
<div class="content">
	<div class="contentItem" style="width:1015px">
		<div class="head"><i class="fa fa-calendar"></i> Planning</div>
		<div>
			<div id="draggableEvents" style="margin:15px; width:250px; float:left"></div>
			<div id="calendar" style="margin:15px; float:right"></div>
		</div>
		
		<div style="height:50px; line-height:50px; float:left; width:1000px;">
			<a href="planning/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Create" class="button1">
		</div>
		
		<script>
		    var c = new calendar({
				id: "calendar",
				startDate: "Today",
				droppable: true,
				data: [
				]
			});
		    
		    var d = new draggableEvents({
				id: "draggableEvents",
				events: [
					[1, "Event1", "#f39c12"],
					[2, "Event2", "#f39c12"],
					[3, "Event3", "#f39c12"],
					[4, "Event4", "#f39c12"],
					[5, "Event5", "#f39c12"]
				]	
			});
			
		</script>
		
		
	</div> 
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
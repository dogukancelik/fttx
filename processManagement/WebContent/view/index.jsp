<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<script type="text/javascript" src="js/calendar.js"></script>
<link rel="stylesheet" href="css/calendar.css">

<div class="content">
	<div class="contentItem" style="width:700px">
		<div class="head"><i class="fa fa-user-circle"></i> My Calendar</div>
		<div id="calendar" style="margin:15px;"></div>
		<script>
		    var c = new calendar({
				id: "calendar",
				startDate: "Today",
				droppable: false,
				data: [
					[1, "31.01.2018", "#dd4b39", "Event1"]
				]
			});
			
		</script>
		
	</div> 
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
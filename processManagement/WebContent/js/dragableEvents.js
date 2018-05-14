var draggableEvents = function(obj){
	var id = obj["id"];
	var events = obj["events"];
	
	for(var i = 0;i<events.length;i++){
		$("#" + id).append("<div id='"+events[i][0]+"' class='fc-event' style='background-color:"+events[i][2]+"'>"+events[i][1]+"</div>");
	}
	
	$("#" + id).children("div").each(function(e) {
        $(this).draggable({
			revert: "invalid",
			refreshPositions: true
		});
		
    });
}
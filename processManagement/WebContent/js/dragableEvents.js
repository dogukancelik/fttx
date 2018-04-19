var draggableEvents = function(obj){
	var id = obj["id"];
	var events = obj["events"];
	
	for(var i = 0;i<events.length;i++){
		$("#" + id).append("<p id='"+events[i][0]+"' class='draggableEvent' style='background-color:"+events[i][2]+"'>"+events[i][1]+"</p>");
	}
	
	$("#" + id).children("p").each(function(e) {
        $(this).draggable({
			revert: "invalid",
			refreshPositions: true
		});
		
    });
}
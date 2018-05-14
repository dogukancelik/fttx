<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="DBContext.DataBase, java.util.*, DAL.WORKDEFINITION,DAL.PROCESS"  %>
<% 

DataBase cr=new DataBase();
WORKDEFINITION wrk=new WORKDEFINITION();
PROCESS pr=new PROCESS();
%>
<link rel="stylesheet" href="js/fullcalendar.min.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/moment.min.js"></script>
<script type="text/javascript" src="js/fullcalendar.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/dragableEvents.js"></script>
<style>
<style>

#external-events {
  float:left;
    z-index: 2;
    top: 0px;
    left: 0px;
    width: 100px;
    padding: 0 10px;
    border: 1px solid #ccc;
    background: #eee;
  }

  
  #external-events .fc-event {
    margin: 1em 0;
    cursor: move;
    font-size: 5em;
  }

  #calendar-container {
    float:left;
    z-index: 1;
    margin-left: 0px;
    width:90%;
  }
.fc-title{
font-size: 8px;
}
  #calendar {
  width:100%;
  height:80%;
    max-width: 100%;
    margin: 0px 50px;

  }
</style>

<%
// {"ProcessId","UserId","WorkdefinitionId","PlanDate","PlanEndDate","UserId","Status"}
		//{"PlanningId","ProcessId","WorkdefinitionId","PlanDate","PlanEndDate","UserId","Status"};
    String  so="";
    String[] rr=new String[cr.planingList().size()];
 
for(String[] st:cr.planingList())
		{
	
	so=so+"{\"id\":"+st[0]+",\"title\":\""+wrk.GetDefinitionList("WorkDefinitionId", st[2]).get(0).getWorkDefinitionName()+" / "+pr.GetProcessList("ProcessId", st[1]).get(0).getProcessName()+"\",\"start\":\""+st[3]+"\", \"end\":\""+st[4]+"\"},";
		System.out.println(so);

				}
		%>

<script>
var ss=[];
$(document).ready(function() {


    /* initialize the external events
    -----------------------------------------------------------------*/

    $('#external-events .fc-event').each(function() {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
        	id: $.trim($(this).attr("id")),
            title: $.trim($(this).text()), // use the element's text as the event title
            stick: true // maintain when user navigates (see docs on the renderEvent method)
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });


    /* initialize the calendar
    -----------------------------------------------------------------*/

   $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        editable: true,
        droppable: true, // this allows things to be dropped onto the calendar
        dragRevertDuration: 0,
        drop: function() {
            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove();
             
            }
        },
        eventClick: function(event){
        	
        },
        eventDragStop: function( event, jsEvent, ui, view ) {
            
            if(isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
                $('#calendar').fullCalendar('removeEvents', event._id);
                var el = $( "<div class='fc-event'>" ).appendTo( '#external-events-listing' ).text( event.title );
                el.draggable({
                  zIndex: 999,
                  revert: true, 
                  revertDuration: 0 
                });
                el.data('event', { title: event.title, id :event.id, stick: true });
            }
        },
        events:[<%=so.substring(0,so.length()-1)%>]
    });


    var isEventOverDiv = function(x, y) {

        var external_events = $( '#external-events' );
        var offset = external_events.offset();
        offset.right = external_events.width() + offset.left;
        offset.bottom = external_events.height() + offset.top;

        // Compare
        if (x >= offset.left
            && y >= offset.top
            && x <= offset.right
            && y <= offset .bottom) { return true; }
        return false;

    }

    
});

function gel(){
	var eventsFromCalendar = $('#calendar').fullCalendar('clientEvents');
	var data=[[]];
	console.log(dat);	
	console.log();
	
	for(var i=0;i<eventsFromCalendar.length;i++){
		var d =new Date(eventsFromCalendar[i]["start"]["_d"]);
		
		var c;
		if(eventsFromCalendar[i]["end"]!=null)
		{
			var end=new Date(eventsFromCalendar[i]["end"]["_d"]);
			c=end.getDate()+"."+(end.getMonth()+1)+"."+end.getFullYear();
		}else {c="";}
		
		var t=d.getDate()+"."+(d.getMonth()+1)+"."+d.getFullYear();
		data[i] = [eventsFromCalendar[i]["id"], eventsFromCalendar[i]["title"], t,c,<%=session.getAttribute("UserId").toString() %>];
		}
	
	$.ajax({
		  type: "POST",
		  url: "/dabaBase",
		  data: {"claendarData": data},
		  success: function(r){
			  
		  }
	});
}

	
</script>

<div class="content" >
	<div class="contentItem" style="width:90%">
		<div class="head"><i class="fa fa-calendar" ></i> Planning List</div>
		<div style="height:30px; line-height:30px">&nbsp<a class="a1" href="planning/create">Create New Planning</a></div>
		
		
			 <div id='calendar-container' >
    <div id='calendar' ></div>

		</div>
		</div> 
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
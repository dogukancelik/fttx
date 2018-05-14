<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>
<%@ page import="DBContext.DataBase, java.util.*, DAL.WORKDEFINITION,DAL.PROCESS, DBContext.CRUD"  %>
<% 
DataBase cr=new DataBase();
WORKDEFINITION wrk=new WORKDEFINITION();
PROCESS pr=new PROCESS();
CRUD crd=new CRUD();
%>

<link rel="stylesheet" href="js/fullcalendar.min.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/moment.min.js"></script>
<script type="text/javascript" src="js/fullcalendar.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/dragableEvents.js"></script>
<style>

#external-events {
  float:left;
    z-index: 2;
    top: 0px;
    left: 0px;
    width: 200px;
    min-height:750px;
    padding: 0 10px;
    border: 1px solid #ccc;
    background: #eee;
    margin-top:40px;
    margin-left: 20px;
  }

  
  #external-events .fc-event {
    margin: 1em 0;
    cursor: move;
  }
.fc-title{
font-size: 8px;
}
  #calendar-container {
    float:left;
    z-index: 1;
    margin-left: 0px;
    margin-top:40px;
    width:70%;
  }

  #calendar {
  width:100%;
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
	
	so=so+"{\"id\":"+st[0]+",\"title\":\""+wrk.GetDefinitionList("WorkDefinitionId", st[2]).get(0).getWorkDefinitionName()+","+pr.GetProcessList("ProcessId", st[1]).get(0).getProcessName()+"\",\"start\":\""+st[3]+"\", \"end\":\""+st[4]+"\"},";
		

				}

%>


<script>

var ss=[];
var i=0;
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
                 ss[i]=$(this).attr("id");
                i=i+1;
                $(this).remove();
             
            }
        },
        eventClick: function(event){
        	
        }, eventRender: function(event, element) {
           gel();
        	
             
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
	
	$("#planingData").attr("value",data);
	$("#planingData2").attr("value",ss);
}

	
	
</script>

<div class="content">
	<div class="contentItem" style="width:100%; margin-left:0px;">
		<div class="head"><i class="fa fa-calendar"></i> Planning Create</div>		
 <div id='external-events'>
    <div id='external-events-listing'>
    	<h4>Process Event</h4>
        <%
     
        ArrayList<String[]> proces= new ArrayList<String[]>();
        String[] att= new String[]{"0"};
    //    proces.add(att);
    if	(((ArrayList)crd.Query("Select ProcessId,WorkdefinitionId from processOrder where ProcessId  not in (Select ProcessId from planning)")).size()>0 ){
     proces =(ArrayList)crd.Query("Select ProcessId,WorkdefinitionId from processOrder where ProcessId  not in (Select ProcessId from planning)");
}else {
	proces.add(att);
	
}
     for( String [] tit:proces){
    String a=((String [])((ArrayList)(crd.Query  ("Select ProcessName from process where ProcessId="+tit[0]))).get(0))[0];
   String b= ((String [] )((ArrayList)  (crd.Query("Select WorkDefinitionName from workdefinition where WorkDefinitionId="+tit[1]))).get(0))[0];
     %>
    <div id="<%=tit[0] %>" class='fc-event'><%=a+" / "+b%> </div>
     		
    <%	  
    }
   
     %>
        
       
         <p style="display:none">
            <input type='checkbox' id='drop-remove' checked='checked' />
            <label for='drop-remove'>remove after drop</label>
          </p>
     </div>
    
  </div>

  <div id='calendar-container'>
    <div id='calendar'></div>
  </div>
<div style="clear:both; "></div>
		<div style="height:50px; line-height:50px;">
		<form action="dataBase" method="post" >
			<input type="hidden" name="actions" value="planning,create">
			<input type="hidden" id="planingData" name="planingData">
			<input type="hidden" id="planingData2" name="planingData2">
			<a href="planning/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="submit" value="Create" class="button1"">
			</form>
		</div>
	
		
		
	</div> 
</div>
<%@ include file="/view/shared/layout_footer.jsp" %>



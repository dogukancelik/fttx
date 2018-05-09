<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessModel, DAL.PROCESS"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];

PROCESS p = new PROCESS();
ProcessModel u = new ProcessModel();
for(ProcessModel st:p.GetProcessList("ProcessId", ID)){
	u.setProcessId(st.getProcessId());
	u.setProcessName(st.getProcessName());
	u.setProcessDescription(st.getProcessDescription());
}


%>

<div class="content">
	<div class="contentItem" style="width:800px">
		<div class="head"><i class="fa fa-user-circle"></i> Process Delete</div>
		<h2>Do you want to delete this process ?</h2>
		<div>Process ID: <b><%=u.getProcessId() %></b></div>
		<div>Process Name: <b><%=u.getProcessName()%></b></div>
		<div>Process Description: <b><%=u.getProcessDescription()%></b></div>
		
		<form action="dataBase" method="post">
		<div style="height:75px; line-height:75px">
			<a href="process/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
			<input type="hidden" name="actions" value="process,delete">
			<input type="hidden" name="ProcessId" value="<%=ID%>">
			<input type="submit" value="Delete" class="button1">
		</div>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
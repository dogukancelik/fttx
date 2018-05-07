<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessOrderModel"  %>

<%
String pathInfo = request.getPathInfo();
String[] pathParts = pathInfo.split("/");
String ID = pathParts[pathParts.length-1];


ProcessOrderModel st = new ProcessOrderModel();

%>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-sort"></i> Process Order Edit</div>
		<form action="#" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process Order: </td>
				</tr>
				<tr>
					<td><select class="select1" name="processorder"><option>select</option></select></td>
				</tr>
				<tr><td><div id="processorderVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Process Order ID: </td>
				</tr>
				<tr>
					<td><select class="select1" name="processorderid"><option>select</option></select></td>
				</tr>
				<tr><td><div id="processorderidVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Work Definition: </td>
				</tr>
				<tr>
					<td><select class="select1" name="workdefinition"><option>select</option></select></td>
				</tr>
				<tr><td><div id="workdefinitionVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Process Check: </td>
				</tr>
				<tr>
					<td><input type="checkbox" name="processcheck"/></td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="processOrder/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="PROCESSORDER,edit">
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>html>
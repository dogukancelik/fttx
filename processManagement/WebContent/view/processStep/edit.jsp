<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessStepModel"  %>

<%ProcessStepModel pm = new ProcessStepModel(); %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-step-forward"></i> Process Step Edit</div>
		<form action="#" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Date: </td>
				</tr>
				<tr>
					<td><input type="date" name="ProcessDate" class="input1" value="<%=pm.getProcessDate()%>"/></td>
				</tr>
				<tr><td><div id="ProcessDateVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">User : </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="UserId"><option>select</option></select>
					</td>
				</tr>			
				<tr><td><div id="UserIdVal" class="validator"></div></td></tr>	
				
				<tr height="75"> 
					<td colspan="2">
						<a href="processStep/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="processStep,edit">
						<input type="submit" value="Edit" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
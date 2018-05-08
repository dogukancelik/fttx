<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessModel"  %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-tasks"></i> Process Create</div>
		<form action="#" method="post" onsubmit="return validate(this)">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Process Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="ProcessName" class="input1"/></td>
				</tr>
				<tr><td><div id="ProcessNameVal" class="validator"></div></td></tr>
				
				<tr>
					<td class="label1">Process Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="ProcessDescription" class="input1"/></td>
				</tr>
				<tr><td><div id="ProcessDescriptionVal" class="validator"></div></td></tr>				
				
				<tr height="75"> 
					<td colspan="2">
						<a href="process/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="PROCESS,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
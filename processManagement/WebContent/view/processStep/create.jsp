<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.ProcessStepModel"  %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-step-forward"></i> Process Step Create</div>
		<form action="#" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Date: </td>
				</tr>
				<tr>
					<td><input type="date" name="date" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">User : </td>
				</tr>
				<tr>
					<td>
						<select class="select1" name="userid"><option>select</option></select>
					</td>
				</tr>			
				
				<tr height="75"> 
					<td colspan="2">
						<a href="processStep/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
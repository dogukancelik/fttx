<%@ include file="/view/shared/secure.jsp" %>

<%@ include file="/view/shared/layout_header.jsp" %>

<%@ page import="model.WorkDefinitionModel"  %>

<div class="content">
	<div class="contentItem" style="width:450px">
		<div class="head"><i class="fa fa-th"></i> Work Definiton Create</div>
		<form action="/processManagement/t" method="post">
		<table style="margin:15px; width:400px;">
			<tbody>
				<tr>
					<td class="label1">Definiton Name: </td>
				</tr>
				<tr>
					<td><input type="text" name="WorkDefinitionName" class="input1"/></td>
				</tr>
				
				<tr>
					<td class="label1">Description: </td>
				</tr>
				<tr>
					<td><input type="text" name="WorkDefinitionDescription" class="input1"/></td>
				</tr>
							
				
				<tr height="75"> 
					<td colspan="2">
						<a href="workDefinition/index" class="a1"><i class="fa fa-arrow-circle-left"></i>Go Back</a>
						<input type="hidden" name="actions" value="WORKDEFINITION,create">
						<input type="submit" value="Create" class="button1">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@ include file="/view/shared/layout_footer.jsp" %>
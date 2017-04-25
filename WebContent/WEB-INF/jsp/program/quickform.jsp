<%@ include file="/common/taglibs.jsp"%>

<s:form action="add-program" method="post">
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Title:</td>
			<td><s:textfield name="title" value="" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Register training" /></td>
		</tr>
	</table>
</s:form>
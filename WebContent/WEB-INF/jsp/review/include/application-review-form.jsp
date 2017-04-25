<%@ include file="/common/taglibs.jsp"%>

<div class="actionMessage">
<h2>Waiting for your approval on budget code <s:property value="code" /></h2>
<s:form action="bc/approve" method="POST">
	<table class="inputform">
		<colgroup>
			<col />
			<col width="25%" />
		</colgroup>
		<tbody>
			<tr>
				<td><s:textarea name="comment" value="%{comment}" /></td>
				<td><s:hidden name="budgetCode" value="%{id}" /><s:submit value="APPROVE" /><br />
				<s:submit value="REJECT" action="bc/reject" /></td>
			</tr>
		</tbody>
	</table>
</s:form></div>
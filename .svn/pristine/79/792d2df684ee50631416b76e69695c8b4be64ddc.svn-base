<%@ include file="/common/taglibs.jsp"%>

<s:if test="((application.status==@org.iita.trainingunit.applications.model.APPLICATIONSTATUS@WAITINGFORCDO) && (user.hasRole('ROLE_TRAININGUNITHEAD') || (user.hasRole('ROLE_DDG') || user.hasRole('ROLE_CFO'))">
	<div class="actionMessage">
	<h2>This TA is waiting for your approval</h2>
	<s:form action="dr/approve" method="POST">
		<table class="inputform">
			<colgroup>
				<col width="25%" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<td><s:hidden name="application" value="%{application.id}" /><s:submit value="APPROVE" /><br />
					<s:submit value="REJECT" action="dr/reject" /></td>
					<td><s:textarea name="comment" value="%{comment}" /></td>
				</tr>
			</tbody>
		</table>
	</s:form></div>
</s:if>
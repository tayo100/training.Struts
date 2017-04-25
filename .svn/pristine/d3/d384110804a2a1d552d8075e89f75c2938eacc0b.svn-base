<%@ include file="/common/taglibs.jsp"%>
<s:form method="POST" action="postreport">
<h2><s:property value="ta.traveler.fullName" />: <s:property value="ta.title" /></h2>
<h3>Start Date: <s:property value="ta.startDate" /> - End Date: <s:property value="ta.endDate" /></h3>
	<table class="inputform">
		<colgroup>
			<col width="25%" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td>Key contacts made/targets met (please give details):</td>
				<td><s:textarea name="taReport.keyContacts" value="%{taReport.keyContacts}" /></td>
			</tr>
			<tr>
				<td>Actual outcomes:</td>
				<td><s:textarea name="taReport.actualOutcomes" value="%{taReport.actualOutcomes}" /></td>
			</tr>
			<tr>
				<td>Actual value to IITA:</td>
				<td><s:textarea name="taReport.actualValue" value="%{taReport.actualValue}" /></td>
			</tr>
			<tr>
				<td>Follow-up/further action to be taken, if applicable and person responsible (e.g. for research, target publication, etc):</td>
				<td><s:textarea name="taReport.followUp" value="%{taReport.followUp}" /></td>
			</tr>
			<tr>
				<td class="identifying"><label>Comments:</label></td>
				<td><s:textarea name="taReport.comment" value="%{taReport.comment}" /></td>
			</tr>
			<tr>
				<td />
				<td><s:hidden name="taId" value="%{ta.id}" /><s:hidden name="id" value="%{taReport.id}" /><s:hidden name="taReport.version" value="%{taReport.version}" /><s:submit value="POST REPORT" /></td>
			</tr>
		</tbody>
	</table>
</s:form>
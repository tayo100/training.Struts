<%@ include file="/common/taglibs.jsp"%>

<s:if test="ta.taReport != null">
	<h2>Travel Report</h2>
	<s:form method="POST" action="postreport/form" cssClass="noprint">
		<s:hidden name="taId" value="%{ta.id}" />
		<s:hidden name="id" value="%{ta.taReport.id}" />
		<div style="margin: 10px 0px 0px 0px;" class="button-bar"><s:submit value="Edit Report" /></div>
	</s:form>
	<h3>Key contacts made/targets met</h3>
	<div style="margin-bottom: 20px;"><s:property value="ta.taReport.keyContacts.replaceAll('\n', '<br />')" escape="false" /></div>
	<h3>Actual outcomes</h3>
	<div style="margin-bottom: 20px;"><s:property value="ta.taReport.actualOutcomes.replaceAll('\n', '<br />')" escape="false" /></div>
	<h3>Actual value to IITA</h3>
	<div style="margin-bottom: 20px;"><s:property value="ta.taReport.actualValue.replaceAll('\n', '<br />')" escape="false" /></div>
	<h3>Follow-up/further action to be taken</h3>
	<div style="margin-bottom: 20px;"><s:property value="ta.taReport.followUp.replaceAll('\n', '<br />')" escape="false" /></div>
	<h3>Comments</h3>
	<div style="margin-bottom: 20px;"><s:property value="ta.taReport.comment.replaceAll('\n', '<br />')" escape="false" /></div>
</s:if>
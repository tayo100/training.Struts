<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="affiliation!update" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<s:if test="organization!=null">
		<tr>
			<td>Organization:</td>
			<td><s:push value="organization"><s:include value="/WEB-INF/jsp/organization/small.jsp" /></s:push></td>
		</tr>
		</s:if>
		<s:if test="person!=null">
		<tr>
			<td>Person:</td>
			<td><s:push value="person"><s:include value="/WEB-INF/jsp/person/small.jsp" /></s:push></td>
		</tr>
		</s:if>
		<tr>
			<td>Affiliation type:</td>
			<td><s:select name="affiliation.type" value="%{type}" list="@org.iita.crm.model.Affiliation$AffiliationType@values()" listValue="%{getText('organization.affiliation.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Job title:</td>
			<td><s:textfield name="affiliation.jobTitle" value="%{jobTitle}" /></td>
		</tr>
		<tr>
			<td>Department:</td>
			<td><s:textfield name="affiliation.department" value="%{department}" /></td>
		</tr>
		<tr>
			<td>Staff ID:</td>
			<td><s:textfield name="affiliation.staffId" value="%{staffId}" cssClass="numeric-input" /></td>
		</tr>
		<tr>
			<td>Start date:</td>
			<td><iita:datepicker name="affiliation.startDate" value="%{startDate}" /></td>
		</tr>
		<tr>
			<td>End date:</td>
			<td><iita:datepicker name="affiliation.endDate" value="%{endDate}" /></td>
		</tr>
		
		<tr>
			<td>Channel:</td>
			<td><s:textfield name="affiliation.channel" value="%{channel}" /></td>
		</tr>
		<tr>
			<td>Subject:</td>
			<td><s:textfield name="affiliation.subject" value="%{subject}" /></td>
		</tr>	
		<tr>
			<td>Text:</td>
			<td><s:textfield name="affiliation.text" value="%{text}" /></td>
		</tr>
		<tr>
			<td>Contacted By:</td>
			<td><s:textfield name="affiliation.contactedby" value="%{contactedby}" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><s:submit value="Update" /> <s:submit value="Remove" action="affiliation!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="person/profile!addAffiliation" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Affiliation type:</td>
			<td><s:select name="affiliationType" list="@org.iita.crm.model.Affiliation$AffiliationType@values()" 
			listValue="%{getText('organization.affiliation.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Organization:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter 
				cssClass="organization" name="organizationId" id="aff.organizationId" listKey="id"
				listValue="fullTitle" url="%{xx}" method="autocompleteOrganization" 
				submitTextTo="organizationName" /></td>
		</tr>
		<tr>
			<td>Staff ID:</td>
			<td><s:textfield name="staffId" value="%{staffId}" cssClass="numeric-input" /></td>
		</tr>
		<tr>
			<td>Start date:</td>
			<td><iita:datepicker name="startDate" value="%{startDate}" /></td>
		</tr>
		<tr>
			<td>End date:</td>
			<td><iita:datepicker name="endDate" value="%{endDate}" /></td>
		</tr>		
		<tr>
			<td>Job title:</td>
			<td><s:textfield name="jobTitle" value="%{jobTitle}" /></td>
		</tr>
		<tr>
			<td>Department:</td>
			<td><s:textfield name="department" value="%{department}" /></td>
		</tr>

		<tr>
			<td>Channel:</td>
			<td><s:textfield name="channel" value="%{channel}" /></td>
		</tr>
		<tr>
			<td>Subject:</td>
			<td><s:textfield name="subject" value="%{subject}" /></td>
		</tr>	
		<tr>
			<td>Text:</td>
			<td><s:textfield name="text" value="%{text}" /></td>
		</tr>
		<tr>
			<td>Contacted By:</td>
			<td><s:textfield name="contactedby" value="%{contactedby}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add affiliation" /></td>
		</tr>
	</table>
</s:form>
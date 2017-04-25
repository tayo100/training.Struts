<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/subsector!update" method="post">
	<s:if test="top instanceof org.iita.crm.model.Partner">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Sub-Sector:</td>
			<td>
			<s:select name="subsector.type" headerKey="" headerValue="Select Subsector" value="%{type}" list="#{'Civil Society':'Civil Society','Government Organization':'Government Organization','Private Sector':'Private Sector','Research':'Research'}" emptyOption="true" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add sub-sector" /></td>
		</tr>
	</table>
</s:form>
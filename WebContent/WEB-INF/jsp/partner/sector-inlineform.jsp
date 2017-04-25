<%@ include file="/common/taglibs.jsp"%>
<s:form action="partner/subsector!update" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td class="ar">Sector:</td>
			<td><s:select name="subsector.type" value="%{type}" 
			list="#{'Civil Society':'Civil Society','Government Organization':'Government Organization',
			'Private Sector':'Private Sector','Research':'Research'}" emptyOption="true" /></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> 
			<s:submit value="Delete" action="partner/subsector!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
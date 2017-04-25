<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/sector!update" method="post">
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
			<td>Sector:</td>
			<td>
			<s:select name="sector.type" headerKey="" headerValue="Select sector" value="%{type}" list="#{'Civil Society':'Civil Society','Government Organization':'Government Organization','Private Sector':'Private Sector','Research':'Research'}" emptyOption="true" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add sector" /></td>
		</tr>
	</table>
</s:form>
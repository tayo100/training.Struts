<%@ include file="/common/taglibs.jsp"%>
<s:form action="partner/corebusiness!updateCoreBusiness" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td class="ar">Category:</td>
			<td><s:textfield name="coreBusiness.type" value="%{type}" /></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="partner/corebusiness!removeCoreBusiness" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
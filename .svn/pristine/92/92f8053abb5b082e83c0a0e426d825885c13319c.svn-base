<%@ include file="/common/taglibs.jsp"%>
<s:form action="partner/corebusinesscategory!update" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td class="ar">Category:</td>
			<td><s:select name="coreBusinessCategory.type" value="%{type}" 
			list="#{'Administration':'Administration','Agriculture & Development':'Agriculture & Development',
			'Economy & Business':'Economy & Business','Education & Research':'Education & Research',
			'Media':'Media'}" emptyOption="true" /></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="partner/corebusinesscategory!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
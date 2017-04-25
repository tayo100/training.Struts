<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/corebusinesscategory!update" method="post">
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
			<td>Category:</td>
			<td>
			<s:select name="coreBusinessCategory.type" value="%{type}" 
			list="#{'Administration':'Administration','Agriculture & Development':'Agriculture & Development',
			'Economy & Business':'Economy & Business','Education & Research':'Education & Research',
			'Media':'Media'}" emptyOption="true" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add core business category" /></td>
		</tr>
	</table>
</s:form>
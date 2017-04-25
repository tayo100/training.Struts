<%@ include file="/common/taglibs.jsp"%>
<s:form action="partner/scale!update" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td class="ar">Scale:</td>
			<td><s:select name="scale.type" value="%{type}" 
			list="#{'International':'International','Local':'Local',
			'National':'National','Subnational':'Subnational','Worldwide':'Worldwide'}" emptyOption="true" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> 
			<s:submit value="Delete" action="partner/scale!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
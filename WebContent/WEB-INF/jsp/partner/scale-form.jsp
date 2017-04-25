<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/scale!update" method="post">
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
			<s:select name="scale.type" value="%{type}" 
			list="#{'Regional':'Regional','Local':'Local',
			'National':'National','Subnational':'Subnational','Global':'Global/International'}" emptyOption="true" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add scale" /></td>
		</tr>
	</table>
</s:form>
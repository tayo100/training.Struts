<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/mandatecrop!updateMandateCrop" method="post">
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
			<td>Mandate Crop:</td>
			<td><s:select name="mandateCrop.type" headerKey = "" headerValue = "Select Crop..." list="#{'Maize':'Maize','Plantain':'Plantain'}" ></s:select></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add Mandate Crop" /></td>
		</tr>
	</table>
</s:form>
<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/corebusiness!updateCoreBusiness" method="post">
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
			<td>Core Business:</td>
			<td><s:textfield name="coreBusiness.type"></s:textfield></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add Core Business" /></td>
		</tr>
	</table>
</s:form>
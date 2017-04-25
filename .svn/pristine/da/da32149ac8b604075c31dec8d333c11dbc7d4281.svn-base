<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/classification!updateClassification" method="post">
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
			<td>Classification:</td>
			<td><s:textfield name="classification.type"></s:textfield></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add Classification" /></td>
		</tr>
	</table>
</s:form>
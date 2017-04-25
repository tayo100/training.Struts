<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/category!updateCategory" method="post">
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
			<td><s:textfield name="pcategory.type"></s:textfield></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add category" /></td>
		</tr>
	</table>
</s:form>
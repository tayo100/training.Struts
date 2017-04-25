<%@ include file="/common/taglibs.jsp"%>
<s:form method="post" action="document!update">
	<s:hidden name="id" value="%{id}" />
	<table class="rawform">
	<colgroup><col width="120" /><col /></colgroup>
		<tr>
			<td class="ar">Title:</td>
			<td><s:textfield name="document.title" value="%{title}" /></td>
		</tr>
		<tr>
			<td class="ar">Type:</td>
			<td><s:textfield name="document.type" value="%{type}" /></td>
		</tr>
		<tr>
			<td />
			<td><s:submit value="Update" /> <s:submit value="Remove" action="document!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
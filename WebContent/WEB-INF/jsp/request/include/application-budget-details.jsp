<%@ include file="/common/taglibs.jsp"%>
<tr>
	<td>Budget code (<s:property value="#status.count" />):</td>
	<td>
		<s:property	value="code" /> <s:if test="costCenter!=null || id==null">
		<b><s:property value="costCenter.description" /></b></s:if><s:else><span style="color: Red;">Cost Center information not found. Please validate!</span></s:else> <s:property value="budgetHolder.fullName" />
	</td>
</tr>
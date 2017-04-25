<%@ include file="/common/taglibs.jsp"%>
<tr>
	<td>Budget code:</td>
	<td><s:hidden name="ta.budgetCodes[%{budgetIndex}].version" value="%{version}" /><s:textfield name="ta.budgetCodes[%{budgetIndex}].code"
		value="%{code}" cssStyle="width: 100px;" /> <s:if test="costCenter!=null || id==null"><b><s:property value="costCenter.description" /></b></s:if><s:else><span style="color: Red;">Cost Center information not found. Please validate!</span></s:else> <s:property value="budgetHolder.fullName" /></td>
</tr>
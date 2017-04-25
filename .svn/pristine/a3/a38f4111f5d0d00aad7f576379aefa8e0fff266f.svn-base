<%@ include file="/common/taglibs.jsp"%>
<div id="affiliation_${id}" class="<s:if test="expired">expired</s:if>"><s:text name="organization.affiliation.%{type}" /> <s:push value="organization">
	<s:include value="/WEB-INF/jsp/organization/small.jsp" />
</s:push>
<s:property value="jobTitle" />
<s:if test="jobTitle!=null">, </s:if><s:property value="department" />
<s:if test="staffId!=null"><b><s:property value="staffId" /></b></s:if>
<s:if test="startDate!=null && endDate!=null">Between</s:if>
<s:if test="startDate!=null"><s:if test="endDate==null">Since </s:if><iita:date name="startDate" format="dd/MM/yyyy" /></s:if>
<s:if test="endDate!=null"><s:if test="startDate!=null"> and </s:if><s:else>Until </s:else><iita:date name="endDate" format="dd/MM/yyyy" /></s:if>
<s:if test="channel!=null"><br />Channel:<b><s:property value="channel" /></b></s:if>
<s:if test="staffId!=null"><br />Subject:<b><s:property value="subject" /></b></s:if>
<s:if test="staffId!=null"><br />Text:<b><s:property value="text" /></b></s:if>
<s:if test="staffId!=null"><br />Contacted By:<b><s:property value="contactedby" /></b></s:if>
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="affiliationForm" targetId="affiliation_${id}">
	<s:include value="../organization/affiliation-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
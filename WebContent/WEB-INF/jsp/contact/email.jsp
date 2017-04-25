<%@ include file="/common/taglibs.jsp"%>
<div id="email_${id}" class="contact email <s:if test="!active">inactive</s:if>">
	<a href="mailto:<s:property value="email" />"><s:property value="email" /></a>
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="emailForm" targetId="email_${id}">
	<s:include value="email-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
<%@ include file="/common/taglibs.jsp"%>
<div id="website_${id}" class="contact website <s:if test="!active">inactive</s:if>"><a target="_blank" href="<s:property value="url" />"><s:property value="url" /></a></div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="webForm" targetId="website_${id}">
	<s:include value="website-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
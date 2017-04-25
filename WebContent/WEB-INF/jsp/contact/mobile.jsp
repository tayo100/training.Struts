<%@ include file="/common/taglibs.jsp"%>
<div id="mobile_${id}" class="contact mobile <s:if test="!active">inactive</s:if>">
	<s:property value="mobileNumber" />
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="mobileForm" targetId="mobile_${id}">
	<s:include value="mobile-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
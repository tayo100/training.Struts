<%@ include file="/common/taglibs.jsp"%>
<div id="phone_${id}" class="contact phone <s:if test="!active">inactive</s:if>">
	<s:property value="rank" /> <s:property value="phoneNumber" /> (<s:property value="type" />)
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="phoneForm" targetId="phone_${id}">
	<s:include value="phone-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
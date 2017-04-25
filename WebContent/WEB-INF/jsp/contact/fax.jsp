<%@ include file="/common/taglibs.jsp"%>
<div id="fax_${id}" class="contact fax <s:if test="!active">inactive</s:if>">
	<s:property value="faxNumber" />
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="faxForm" targetId="fax_${id}">
	<s:include value="fax-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
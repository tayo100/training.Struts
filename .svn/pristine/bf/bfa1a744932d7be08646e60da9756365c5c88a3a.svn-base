<%@ include file="/common/taglibs.jsp"%>
<div id="classification_${id}" class="classification">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="classificationForm" targetId="classification_${id}">
	<s:include value="classification-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
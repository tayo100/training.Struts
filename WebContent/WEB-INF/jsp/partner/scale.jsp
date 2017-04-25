<%@ include file="/common/taglibs.jsp"%>
<div id="scale_${id}" class="category">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="scaleForm" targetId="scale_${id}">
	<s:include value="scale-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
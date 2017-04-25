<%@ include file="/common/taglibs.jsp"%>
<div id="mandatecrop_${id}" class="mandatecrop">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="mandatecropForm" targetId="mandatecrop_${id}">
	<s:include value="mandatecrop-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
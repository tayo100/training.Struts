<%@ include file="/common/taglibs.jsp"%>
<div id="sector_${id}" class="category">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="sectorForm" targetId="sector_${id}">
	<s:include value="sector-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
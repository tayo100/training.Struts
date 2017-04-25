<%@ include file="/common/taglibs.jsp"%>
<div id="corebusiness_${id}" class="corebusiness">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="corebusinessForm" targetId="corebusiness_${id}">
	<s:include value="corebusiness-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
<%@ include file="/common/taglibs.jsp"%>
<div id="iitahub_${id}" class="iitahub">
	<s:text name="partner.hub.%{hub}" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="iitahubForm" targetId="iitahub_${id}">
	<s:include value="iitahub-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
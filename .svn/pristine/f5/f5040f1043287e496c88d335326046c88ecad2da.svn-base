<%@ include file="/common/taglibs.jsp"%>
<div id="category_${id}" class="category">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="categoryForm" targetId="category_${id}">
	<s:include value="category-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
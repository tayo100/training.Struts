<%@ include file="/common/taglibs.jsp"%>
<div id="corebusinesscategory_${id}" class="category">
	<s:property value="type" />
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN, ROLE_ADMIN">
<iita:inlineeditor id="corebusinesscategoryForm" targetId="corebusinesscategory_${id}">
	<s:include value="corebusinesscategory-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
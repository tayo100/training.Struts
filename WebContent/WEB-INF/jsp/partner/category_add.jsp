<%@ include file="/common/taglibs.jsp"%>
<span id="category_%{id}">Add new category...</span>
<iita:inlineeditor id="" targetId="category_%{id}">
	<s:include value="/WEB-INF/jsp/partner/category-form.jsp" />
</iita:inlineeditor>
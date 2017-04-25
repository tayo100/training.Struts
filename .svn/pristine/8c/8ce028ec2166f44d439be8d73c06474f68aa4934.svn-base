<%@ include file="/common/taglibs.jsp"%>
<div id="rss_${id}" class="contact rss <s:if test="!active">inactive</s:if>">
	RSS: <em><s:property value="rss" /></em> / <em><s:property value="rssComment" /></em>
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="rssForm" targetId="rss_${id}">
	<s:include value="rss-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
<%@ include file="/common/taglibs.jsp"%>
<span class="document small">
<s:push value="entity">
	<s:include value="tiny.jsp" />
</s:push>
<s:push value="document">
	document <b><a href="<s:url action="document-download" />?file=<s:property value="filePath" />"><s:property value="title" /></a></b> uploaded by <s:property value="createdBy" /> on <s:date name="createdDate" format="dd/MM/yyyy HH:mm" />
</s:push>
</span>
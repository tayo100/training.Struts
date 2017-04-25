<%@ include file="/common/taglibs.jsp"%>
<span class="document small" id="document_${id}">
<s:date name="createdDate" format="dd/MM/yyyy" /> <s:property value="type" /> <a href="<s:url action="document-download" />?file=<s:property value="filePath" />"><s:property value="title" /></a> uploaded by <s:property value="createdBy" />
</span>
<iita:authorize ifAnyGranted="ROLE_CGO">
	<iita:inlineeditor targetId="document_${id}" id="%{'editdocu_' + id}">
		<s:include value="document-form.jsp" />
	</iita:inlineeditor>
</iita:authorize>

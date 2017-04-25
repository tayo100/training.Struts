<%@ include file="/common/taglibs.jsp"%>
<span class="document small" id="entdoc_${id}">
<s:push value="document">
	<s:if test="isAllowPublic()">
		<s:date name="createdDate" format="dd/MM/yyyy" /> <s:property value="type" /> <a href="<s:url action="document-download" />?file=<s:property value="filePath" />"><s:property value="title" /></a> uploaded by <s:property value="createdBy" />
	</s:if>
</s:push>
</span>
<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_CGO">
	<iita:inlineeditor targetId="entdoc_${id}" id="%{'editentdocu_' + id}">
		<s:include value="entitydocument-trainingproposal-form.jsp" />
	</iita:inlineeditor>
</iita:authorize>

<%@ include file="/common/taglibs.jsp"%>
<span class="trainee small <s:if test="expired">expired</s:if>"><a href="<s:url action="trainee/profile"/>?id=<s:property value="id" />"><s:if
	test="person!=null">
	<span class="person small <s:property value="person.gender" />"><s:property value="person.legalName" />:</span>
</s:if> <iita:text maxLength="60" value="researchTopic" /></a></span>
<%@ include file="/common/taglibs.jsp"%>
<h2>Contact Information</h2>
<a href="<s:url action="person/profile" />?id=<s:property value="id" />">Jump to <s:property value="fullName" />'s profile</a>
<s:if test="lastEmail!=null || lastPhone!=null || lastAddress!=null">
	<h3>Last known contact details</h3>
</s:if>
<s:if test="lastEmail!=null">
	<s:push value="lastEmail">
		<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
	</s:push>
</s:if>
<s:if test="lastPhone!=null">
	<s:push value="lastPhone">
		<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
	</s:push>
</s:if>
<s:if test="lastAddress!=null">
	<s:push value="lastAddress">
		<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
	</s:push>
</s:if>
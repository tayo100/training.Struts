<%@ include file="/common/taglibs.jsp"%>
<span class="person small <s:property value="gender" />"><a href="<s:url action="person/profile"/>?id=<s:property value="id" />"><s:property value="legalName" /></a>
 
<s:if test="lastAffiliation!=null">
	<s:if test="lastAffiliation.organization.shortName!=null">
		(<a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.shortName" /></a>)
		</s:if>
	<s:else>
		(<a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.title" /></a>)
		</s:else>
</s:if> <s:if test="lastEmail!=null">
	<s:push value="lastEmail">
		<s:include value="/WEB-INF/jsp/contact/inline-email.jsp" />
	</s:push>
</s:if>
</span>
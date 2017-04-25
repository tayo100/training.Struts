<%@ include file="/common/taglibs.jsp"%>
<div id="affiliation_${id}" class="<s:if test="status==INACTIVE">expired</s:if>"><s:text name="partner.partnerContact.%{type}" /> <s:push value="person">
	<s:include value="/WEB-INF/jsp/person/small.jsp" />
</s:push>
<s:if test="discipline!=null"> (<s:property value="discipline" />)</s:if>
<s:if test="status!=null"> - <s:text name="partner.partnerContact.status.%{status}" /></s:if>
<s:if test="position!=null"> as <s:property value="position" /></s:if>
</div>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
<iita:inlineeditor id="affiliationForm" targetId="affiliation_${id}">
	<s:include value="../partner/affiliation-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
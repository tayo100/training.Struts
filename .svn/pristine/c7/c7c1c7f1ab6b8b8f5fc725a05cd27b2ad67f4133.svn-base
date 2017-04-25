<s:if test="top instanceof org.iita.crm.model.Person">
	<%@include file="/WEB-INF/jsp/person/quickinfo.jsp" %>
	<s:action name="person/merge-profile" executeResult="true" ignoreContextParams="true">
		<s:param name="id" value="%{id}" />
	</s:action>
</s:if>
<s:elseif test="top instanceof org.iita.crm.model.Organization">
	<%@include file="/WEB-INF/jsp/organization/quickinfo.jsp" %>
	<s:action name="organization/merge-profile" executeResult="true" ignoreContextParams="true">
		<s:param name="id" value="%{id}" />
	</s:action>
</s:elseif>
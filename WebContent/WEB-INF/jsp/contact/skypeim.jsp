<%@ include file="/common/taglibs.jsp"%>
<div id="skypeim_${id}" class="contact skypeim <s:if test="!active">inactive</s:if>">
	Sype/IM: <em><s:property value="skypeimAddress" /></em> 

</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="skypeimForm" targetId="skypeim_${id}">
	<s:include value="skypeim-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
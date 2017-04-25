<%@ include file="/common/taglibs.jsp"%>
<div class="trainee quick <s:if test="expired">expired</s:if>">
	<h3><a href="<s:url action="person/profile"/>?id=<s:property value="person.id" />"><s:property value="person.legalName" /></a>:
	<a href="<s:url action="trainee/profile"/>?id=<s:property value="id" />"><iita:text maxLength="60" value="researchTopic" /></a></h3>
	<div>Start date: <s:date name="startDate" format="dd/MM/yyyy" />  End date: <s:date name="endDate" format="dd/MM/yyyy" />
	<s:if test="extensionDate!=null">Extension date: <s:date name="extensionDate" format="dd/MM/yyyy" /></s:if></div>
	<s:if test="expired">
		<div><b>This IITA training finished <s:date name="extensionDate==null || endDate>extensionDate ? endDate : extensionDate" nice="true" />.</b></div>
	</s:if>
	<div><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />"><iita:text value="researchTopic" /></a>
	<s:property value="location" /> <s:property value="program" /> 
	</div>
</div>
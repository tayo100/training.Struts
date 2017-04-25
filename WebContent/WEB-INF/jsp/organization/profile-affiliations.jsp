<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title><s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="org-navigation.jsp"%>

<h2>Affiliations to <s:property value="profile.title" /></h2>
<iita:authorize ifAnyGranted="ROLE_CRM">
	<iita:collapse id="personaffiliation" closedHeading="Add affiliation...">
		<s:include value="affiliation-person-form.jsp" />
	</iita:collapse>
</iita:authorize>

<s:if test="affiliations!=null">
	<s:push value="affiliations">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'id=' + profile.id}" />
		</s:include>
	</s:push>

	<ul>
		<s:iterator value="affiliations.results">
			<li><s:include value="affiliation.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>


</body>
</html>
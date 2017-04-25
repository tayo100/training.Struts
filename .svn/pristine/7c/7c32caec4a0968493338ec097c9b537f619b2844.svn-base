<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>PARTNERSHIP: <s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="partner-navigation.jsp"%>

<h2>Associations to <s:property value="profile.title" /></h2>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
	<iita:collapse id="personaffiliation" closedHeading="Add association...">
		<s:include value="affiliation-person-form.jsp" />
	</iita:collapse>
</iita:authorize>
<s:if test="associates!=null">
<s:if test="associates.totalHits > 0">
	<s:push value="associates">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'id=' + profile.id}" />
		</s:include>
	</s:push>

	<ul>
		<s:iterator value="associates.results" status="status">
			<li><s:include value="affiliation.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
</s:if>

</body>
</html>
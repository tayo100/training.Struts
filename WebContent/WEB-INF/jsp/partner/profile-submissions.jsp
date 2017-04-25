<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title><s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="partner-navigation.jsp"%>

<h2>Submissions relating to <s:property value="profile.title" /></h2>

<s:if test="submissions!=null">
	<s:push value="submissions">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'id=' + profile.id}" />
		</s:include>
	</s:push>

	<s:push value="submissions.results">
		<s:include value="/WEB-INF/jsp/projectbase/submissions-list.jsp" />
	</s:push>
</s:if>


</body>
</html>
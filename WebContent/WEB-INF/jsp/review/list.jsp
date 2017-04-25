<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Application requests pending your approval</title>
</head>
<body>
<s:if test="paged.results.size>0">
	<s:include value="/WEB-INF/jsp/paging.jsp">
		<s:param name="page" value="paged.page" />
		<s:param name="pages" value="paged.pages" />
		<s:param name="pageSize" value="paged.pageSize" />
		<s:param name="href" value="%{''}" />
	</s:include>

	<s:include value="/WEB-INF/jsp/request/include/table-listing-full.jsp" />
</s:if>
<s:else>
	<p>There are no application requests waiting for your approval.</p>
</s:else>
</body>
</html>
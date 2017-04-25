<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Training Programs List</title>
</head>
<body>

<s:if test="ownerId != null">
<s:include value="/WEB-INF/jsp/include/trainingprogram-listing-full.jsp" />
</s:if>
<s:else>
<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>

<s:include value="/WEB-INF/jsp/include/pagedtrainingprogram-listing-full.jsp" />
</s:else>

</body>
</html>
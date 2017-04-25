<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>CFO approval Training Application records list</title>
</head>
<body>
<s:if test="pending.totalHits>0">
	<s:include value="/WEB-INF/jsp/paging.jsp">
		<s:param name="page" value="paged.page" />
		<s:param name="pages" value="paged.pages" />
		<s:param name="pageSize" value="paged.pageSize" />
		<s:param name="href" value="%{''}" />
	</s:include>
	<div class="actionMessage">There are <b><s:property value="pending.totalHits" /></b> training application requests waiting for your
	approval. <input type="button" onClick="javascript: window.location='<s:url action="pending" />';" value="View pending" /></div>
</s:if>

<s:include value="/WEB-INF/jsp/request/include/table-listing-full.jsp" />
</body>
</html>
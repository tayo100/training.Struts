<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard</title>
</head>
<body>

<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>
<div style="padding: 2px 2px 3px 5px; background-color: rgb(239, 239, 239);">
<s:form method="get" action="trainees/export" namespace="/"><s:submit value="Export to Excel" /></s:form></div>
<s:include value="/WEB-INF/jsp/include/pagedtrainees-listing-full.jsp" />
</body>
</html>
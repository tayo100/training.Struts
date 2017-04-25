<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Alumni records</title>
</head>
<body>
<div class="button-bar">
<a href="<s:url action="alumni/import" />">Import Alumni Data</a> &nbsp;
<a href="<s:url action="alumni/search" />">Search Alumni</a> 
<!-- <a href="<s:url action="alumni/export" />">Export to Excel</a> -->
</div>

<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>


<s:include value="/WEB-INF/jsp/include/pagedalumni-listing.jsp" />

</body>
</html>
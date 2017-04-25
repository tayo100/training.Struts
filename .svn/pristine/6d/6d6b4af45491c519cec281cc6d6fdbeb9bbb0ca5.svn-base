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
<div class="button-bar">
<security:authorize ifAnyGranted="ROLE_PARTNERADMIN">
<a href="<s:url action="partner/import" />">Import Partners</a>
&nbsp;<a href="<s:url action="partner/importcontact" />">Import Partner Contacts</a>
</security:authorize>
<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
&nbsp;<a href="<s:url action="partner/search" />">Search Partners</a> 
</security:authorize>
</div>
<s:include value="/WEB-INF/jsp/include/pagedpartners-listing.jsp" />
</body>
</html>
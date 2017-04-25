<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Search results</title>
</head>
<body>
<s:if test="projects!=null && projects.size>0">
	<h2>Projects</h2>
	<ul>
		<s:iterator value="projects">
			<li><s:include value="/WEB-INF/jsp/projectbase/short.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:if test="agreements!=null && agreements.size>0">
	<h2>Agreements</h2>
	<ul>
		<s:iterator value="agreements">
			<li><s:include value="/WEB-INF/jsp/agreement/short.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:if test="persons!=null && persons.size>0">
	<h2>Persons</h2>
	<ul>
		<s:iterator value="persons">
			<li><s:include value="/WEB-INF/jsp/person/small.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:if test="organizations!=null && organizations.size>0">
	<h2>Organizations</h2>
	<ul>
		<s:iterator value="organizations">
			<li><s:include value="/WEB-INF/jsp/organization/quickinfo.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:if test="partners!=null && partners.size>0">
	<h2>Partners</h2>
	<ul>
		<s:iterator value="partners">
			<li><s:include value="/WEB-INF/jsp/partner/quickinfo.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>

</body>
</html>
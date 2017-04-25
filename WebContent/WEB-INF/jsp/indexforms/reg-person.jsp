<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Person registration</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<div class="actionMessage">Before registering new persons, please check if the record about the person already exists by searching the name(s).</div>
				
				<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<h2>Register new person</h2>
					<s:include value="/WEB-INF/jsp/person/person-quickform.jsp" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<em>No access granted to use this page!</em>
				</security:authorize>
			</td>
			<td>
				<s:if test="persons!=null && persons.size>0">
					<h3>Last updated persons</h3>
					<ul>
					<s:iterator value="persons">
						<li><s:include value="/WEB-INF/jsp/person/small.jsp" /></li>
					</s:iterator>
					</ul>
				</s:if>
			</td>
		</tr>
	</table> 
</body>
</html>
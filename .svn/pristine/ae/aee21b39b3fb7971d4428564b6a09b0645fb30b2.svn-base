<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Alumni data</title>
</head>
<body>
<s:form method="post" action="alumni/search!query">
<table class="inputform">
						<colgroup>
							<col width="200px" />
							<col />
						</colgroup>
						<tr>
							<td><label>Research Topic:</label></td>
							<td><s:textfield name="researchTopic" value="%{researchTopic}" /></td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td><s:textfield name="lastName" value="%{lastName}" /></td>
						</tr>
						<tr>
							<td><label>First name:</label></td>
							<td><s:textfield name="firstName" value="%{firstName}" /></td>
						</tr>
						<tr>
							<td><label>University:</label></td>
							<td><s:textfield name="org" value="%{org}" /></td>
						</tr>
						<tr>
							<td><label>Gender:</label></td>
							<td><s:select emptyOption="true" list="#{'FEMALE':'Female','MALE':'Male'}" name="gender" value="%{gender}" /></td>
						</tr>
						<tr>
							<td><label>Between:</label></td>
							<td><iita:datepicker name="fromDate" value="%{fromDate}" format="dd/MM/yyyy" /> and <iita:datepicker name="toDate" value="%{toDate}" format="dd/MM/yyyy" /><s:submit value="Search" /></td>
						</tr>
					</table>
				</s:form>

<s:if test="paged!=null">	
	<s:push value="paged">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'id=' + [1].query.id}" />
		</s:include>
		<s:if test="report!=null">
			<s:property value="report" escape="false" />
		</s:if>
		<s:else>
			<s:include value="query-results.jsp" />
		</s:else>
	</s:push>
	<s:if test="paged.totalHits > 0">
		<div class="button-bar"><iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER">
			<b><a href="<s:url action="query/edit" />?id=<s:property value="query.id" />">Edit query</a></b>
		</iita:authorize> <a href="<s:url action="query/run!download" />?id=<s:property value="query.id" />">Export to Excel</a></div>
	</s:if>
</s:if>

</body>
</html>
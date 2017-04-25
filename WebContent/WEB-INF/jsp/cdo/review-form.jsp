<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>CDO Head Training Application Approval Form</title>
</head>
<body>

<div class="actionMessage">
<h2>Waiting for CDO Head's approval on Training Application</h2>
<s:form action="approve" method="post">
	<table class="inputform">
		<colgroup>
			<col width="25%" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td><s:hidden name="id" value="%{id}" /><s:submit value="APPROVE" /><br />
				<s:submit value="REJECT" action="reject" /></td>
				<td class="identifying"><label>Comments:</label><br />
				<s:textarea name="comment" value="%{comment}" /></td>
			</tr>
		</tbody>
	</table>
</s:form></div>

<s:include value="/WEB-INF/jsp/include/application-actionlog.jsp" />


<s:include value="/WEB-INF/jsp/request/include/application-head.jsp" />

</body>
</html>
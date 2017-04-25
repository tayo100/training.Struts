<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Trainee registration</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<div class="actionMessage">Before registering new trainee, please check if the record about the trainee already exists by searching the name(s).</div>
				
				<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<h2>Register trainee</h2>
					<s:include value="/WEB-INF/jsp/trainee/quickform.jsp" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<em>No access granted to use this page!</em>
				</security:authorize>
			</td>
			<td>
				<s:if test="trainees!=null && trainees.size>0">
					<h3>Last updated trainees</h3>
					<ul>
					<s:iterator value="trainees">
						<li><s:include value="/WEB-INF/jsp/trainee/small.jsp" /></li>
					</s:iterator>
					</ul>
				</s:if>
			</td>
		</tr>
	</table> 
</body>
</html>
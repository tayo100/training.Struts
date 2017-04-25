<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Training Program registration</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<div class="actionMessage">Before registering new training program, please check if the record about the training program already exists by searching for any related information.</div>
				
				<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<h2>Register new training</h2>
					<s:include value="/WEB-INF/jsp/program/quickform.jsp" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<em>No access granted to use this page!</em>
				</security:authorize>
			</td>
			<td>
				<s:if test="programs!=null && programs.size>0">
					<h3>Last updated programs</h3>
					<ul>
					<s:iterator value="programs">
						<li><s:include value="/WEB-INF/jsp/program/short.jsp" /></li>
					</s:iterator>
					</ul>
				</s:if>
			</td>
		</tr>
	</table> 
</body>
</html>
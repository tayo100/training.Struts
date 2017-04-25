<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Alert messaging status</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
					<s:if test="alerts!=null && alerts.size>0">
						<h2>Last pending alert notifications</h2>
						<ul>
							<s:iterator value="alerts">
								<li><s:include value="/WEB-INF/jsp/alert/quickinfo.jsp" /></li>
							</s:iterator>
						</ul>
					</s:if>
				</security:authorize>
			</td>
			<td>
				<s:if test="applications!=null && applications.size>0">
					<h3>Latest applications</h3>
					<ul>
					<s:iterator value="applications">
						<li><s:include value="/WEB-INF/jsp/include/applications-short.jsp" /></li>
					</s:iterator>
					</ul>
				</s:if>
			</td>
		</tr>
	</table> 
</body>
</html>
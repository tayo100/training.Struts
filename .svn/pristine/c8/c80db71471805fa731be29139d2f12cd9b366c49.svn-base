<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Partner registration</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<div class="actionMessage">Before registering new partner, please check if the record about the partner already exists.</div>
				
				<security:authorize ifAnyGranted="ROLE_PARTNERADMIN">
					<h2>Register new partner</h2>
					<s:include value="/WEB-INF/jsp/partner/quickform.jsp" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_PARTNERADMIN">
					<em>No access granted to use this page!</em>
				</security:authorize>
			</td>
			<td>
				<s:if test="partners!=null && partners.size>0">
					<h3>Last updated partners</h3>
					<ul>
					<s:iterator value="partners">
						<li><s:include value="/WEB-INF/jsp/partner/small.jsp" /></li>
					</s:iterator>
					</ul>
				</s:if>
			</td>
		</tr>
	</table> 
</body>
</html>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Dashboard: Tag cloud browser</title>
</head>
<body>
	<table style="width:100%">
		<colgroup><col width="70%" /><col width="30%" /></colgroup>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<h2>Tag cloud <small><a href="<s:url action="tag/cloud" />">Browse tag cloud</a></small></h2>
				<s:action name="tag/cloud!inline" executeResult="true" ignoreContextParams="true" />
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
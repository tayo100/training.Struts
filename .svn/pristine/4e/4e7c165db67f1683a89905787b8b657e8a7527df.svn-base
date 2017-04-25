<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Deleted entities</title>
</head>
<body>
<table class="data-listing">
	<thead>
		<tr>
			<td />
			<td>Time</td>
			<td>User</td>
			<td>Number</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="deletedEntities">
			<tr>
				<td><s:form method="post" action="undelete!undelete">
					<s:hidden name="hash" value="%{class.name}@%{hashCode()}" />
					<s:submit value="Undelete" />
				</s:form></td>
				<td><iita:date name="time" format="dd/MM/yyyy HH:mm" /></td>
				<td><s:property value="user.fullName" /></td>
				<td><s:property value="entities.size()" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</body>
</html>
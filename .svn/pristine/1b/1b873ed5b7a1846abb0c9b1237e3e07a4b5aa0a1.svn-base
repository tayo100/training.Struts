<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Query properties</title>
</head>
<body>
<s:form method="post" action="query/edit!update">
	<s:hidden name="id" value="%{query.id}" />
	<table class="inputform">
		<colgroup>
			<col width="150" />
			<col />
		</colgroup>
		<tr>
			<td>Title:</td>
			<td><s:textfield name="query.title" value="%{query.title}" /></td>
		</tr>
		<tr>
			<td>Short name:</td>
			<td><s:textfield name="query.shortName" value="%{query.shortName}" cssClass="numeric-input" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><s:textarea name="query.description" value="%{query.description}" cssClass="sizable-textarea" /></td>
		</tr>
		<tr>
			<td>JPA:</td>
			<td><s:textarea name="query.query" value="%{query.query}" cssClass="sizable-textarea" /></td>
		</tr>
		<tr>
			<td>Headings:</td>
			<td><s:textarea name="query.heads" value="%{query.heads}" cssClass="sizable-textarea" /></td>
		</tr>
		<tr>
			<td>Allowed roles:</td>
			<td><s:textfield name="query.allowedRoles" value="%{query.allowedRoles}" /></td>
		</tr>
		<tr>
			<td>Template:</td>
			<td><s:select name="query.templateName" value="%{query.templateName}" list="templates" listKey="shortName" listValue="title" headerKey=""
				headerValue="[No template]" /></td>
		</tr>

		<tr>
			<td />
			<td><s:submit value="Update" /> <s:submit value="Copy" action="query/edit!copy" /> <s:submit value="Test" action="query/edit!test" /> <s:if
				test="query.id!=null">
				<s:submit value="Remove" action="query/edit!remove" cssClass="button-delete"
					onclick="javascript: return confirm('Are you sure you want to remove this record?');" />
			</s:if></td>
		</tr>
	</table>
</s:form>

<s:if test="report!=null">
	<s:property value="report" escape="false" />
</s:if>

<s:if test="testData!=null">
	<h1>Query results</h1>
	<s:push value="testData">
		<s:include value="query-results.jsp" />
	</s:push>
	<p>Note that we're only displaying first 40 rows of your query results.</p>
</s:if>
</body>
</html>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Import XLS data</title>
</head>
<body>
<h2>Alumni Import</h2>
<s:form method="post" enctype="multipart/form-data" action="alumni/import!upload">
	<s:hidden name="type" value="junior" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>XLS File:</td>
			<td><s:file name="uploads" accept="*.xls" /></td>
		</tr>
		<tr>
			<td />
			<td><s:submit value="Upload" /></td>
		</tr>
	</table>
</s:form>

<s:if test="allXlsRowData!=null">
	<h1>List of Alumni in XLS file</h1>
	
	<s:set name="alumnis" value="alumnis" />
	<s:set name="allXlsRowData" value="allXlsRowData" />
	<s:push value="allXlsRowData">
		<s:include value="alumni-listing.jsp" />
	</s:push>
	<s:form method="post" action="alumni/import!save">
		<s:submit value="Import to Database" />
	</s:form>
</s:if>
</body>
</html>
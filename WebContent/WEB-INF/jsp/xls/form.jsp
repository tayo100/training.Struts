<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Import XLS data</title>
</head>
<body>
<h2>Importing <a href="<s:url action="program/profile"/>?id=<s:property value="group.id" />"><s:property value="group.title" /></a> attendees</h2>
<s:form method="post" enctype="multipart/form-data" action="xls/import!upload">
	<s:hidden name="id" value="%{group.id}" />
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

<s:if test="attendance!=null">
	<h1>Completed Attendance in XLS file</h1>
	
	<s:set name="attendance" value="attendance" />
	<s:include value="../program/attendance-listing.jsp" />

	<s:form method="post" action="xls/import!save">
		<s:hidden name="id" value="%{group.id}" />
		<s:submit value="Import to Database" />
	</s:form>
</s:if>

</body>
</html>
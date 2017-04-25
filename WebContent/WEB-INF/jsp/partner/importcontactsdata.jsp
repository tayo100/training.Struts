<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>PARTNERSHIP: Import XLS partner contacts data</title>
</head>
<body>
<h2>Partner Contacts Import</h2>
<s:form method="post" enctype="multipart/form-data" action="partner/importcontact!uploadcontacts">
	<s:hidden name="type" value="partner" />
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
	<h1>List of Partner Contacts in XLS file</h1>
	
	<s:set name="partners" value="partners" />
	<s:set name="allXlsRowData" value="allXlsRowData" />
	<s:push value="allXlsRowData">
		<s:include value="partner-contacts-listing.jsp" />
	</s:push>
	<s:form method="post" action="partner/importcontact!savecontacts">
		<s:submit value="Import to Database" />
	</s:form>
</s:if>
</body>
</html>
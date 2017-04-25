<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TA Preview Form</title>
</head>
<body>
<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@NEW">
	<div class="actionMessage">The TA has not been filed for approval yet!</div>
	<div class="button-bar">
	<s:form method="POST">
		<s:hidden name="id" value="%{ta.id}" />
		<s:submit action="edit" cssStyle="font-size:16;font-weight:Bold;" value="Go back and edit" />
		<s:submit action="file-ta" cssStyle="font-size:16;font-weight:Bold;" value="Send TA for approval" />
	</s:form></div>
</s:if>
<s:include value="include/ta-view.jsp" />
</body>
</html>
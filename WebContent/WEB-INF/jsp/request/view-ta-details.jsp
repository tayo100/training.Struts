<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Travel Authorization details</title>
</head>
<body>
<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@WAITING || ta.status==@org.iita.travelauth.model.TaStatus@WAITINGFORCFO || ta.status==@org.iita.travelauth.model.TaStatus@LINEMANAGER || ta.status==@org.iita.travelauth.model.TaStatus@WAITINGFORDIRECTOR">
<div class="button-bar">
<s:form method="POST" action="cancel-ta" cssClass="noprint">
	<s:hidden name="id" value="%{ta.id}"></s:hidden>
		<s:submit value="Cancel request & edit" />
</s:form>

<s:form method="POST" action="edit-ta" cssClass="noprint">
	<s:hidden name="id" value="%{ta.id}"></s:hidden>
		<s:submit value="Edit TA" />
</s:form>

<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_CFO,ROLE_MONITOR,ROLE_MANAGER">
<s:form method="get" action="send-reminder" cssClass="noprint">
	<s:hidden name="id" value="%{ta.id}"></s:hidden>
		<s:submit value="Send e-mail reminders" />
</s:form>
</security:authorize>
</div>
</s:if>
<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@APPROVED || ta.status==@org.iita.travelauth.model.TaStatus@REPORTFILED">
 <security:authorize ifAnyGranted="ROLE_CFO">
 <div class="button-bar">
	<s:form method="POST" action="cancel-ta" cssClass="noprint">
		<s:hidden name="id" value="%{ta.id}"></s:hidden>
			<s:submit value="Cancel TA request" />
	</s:form>
	
	<s:form method="POST" action="edit-ta" cssClass="noprint">
	<s:hidden name="id" value="%{ta.id}"></s:hidden>
		<s:submit value="Edit TA request" />
</s:form>
 </div>
 </security:authorize>
 </s:if>
<s:include value="/WEB-INF/jsp/request/include/ta-view.jsp" />
</body>
</html>
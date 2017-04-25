<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Edit Travel Authorization request</title>
</head>
<body>

<s:include value="include/form-instructions.jsp" />

<s:form method="POST" action="savedraft">
	<s:include value="include/ta-form.jsp" />
	
	<div style="margin: 10px 0px 0px 250px;" class="button-bar">
	<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@NEW">
		<s:submit value="Save Draft & Continue Editing" /> 
		<s:submit action="savedraft!previewTa" value="Review and send for approval" /> 
		<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@NEW">
			<s:submit action="delete" cssStyle="color: Red;" value="Delete record" />		
		</s:if>
	</s:if>
	<s:else>
		<s:submit action="edit!previewTa" value="Update TA request" /> 
	</s:else>
	</div>
	<div style="margin: 10px 0px 0px 250px;" class="actionMessage"><strong>NB:</strong> To file your TA for approval, click on Finalize TA button. On the TA details page that appears, click on
		File TA button to finally submit your TA request.</div>
</s:form>

<s:if test="ta.id!=null">
	<h2>Attachments</h2>
	<p>Please attach supporting documents. Note: If you made changes to TA details above, <b>Save</b> changes before attaching files! You can add attachments any time, even when your TA is pending for approval, or being fully finalized.</p>
	<s:include value="include/attachments.jsp" />

	<s:include value="/WEB-INF/jsp/request/include/ta-actionlog.jsp" />
</s:if>
</body>
</html>
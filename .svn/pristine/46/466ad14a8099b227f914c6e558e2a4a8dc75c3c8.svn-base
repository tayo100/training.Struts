<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Mail: <s:property value="message.message.subject" /></title>
</head>
<body>
<s:if test="message!=null">
	<s:set name="mime" value="message.message" />
	<table class="inputform">
		<colgroup>
			<col width="200" />
			<col />
		</colgroup>
		<tr>
			<td>Sent:</td>
			<td><iita:date name="#mime.sentDate" format="dd/MM/yyyy HH:mm" /></td>
		</tr>
		<tr>
			<td>Received:</td>
			<td><iita:date name="message.createdDate" format="dd/MM/yyyy HH:mm" /></td>
		</tr>
		<tr>
			<td>From:</td>
			<td><s:iterator value="#mime.from">
				<span><s:property /></span>
			</s:iterator></td>
		</tr>
		<s:if test="#mime.getRecipients(@javax.mail.Message$RecipientType@TO).length>0">
			<tr>
				<td>To:</td>
				<td><s:iterator value="#mime.getRecipients(@javax.mail.Message$RecipientType@TO)">
					<span><s:property /></span>
				</s:iterator></td>
			</tr>
		</s:if>
		<s:if test="#mime.getRecipients(@javax.mail.Message$RecipientType@CC).length>0">
			<tr>
				<td>Cc:</td>
				<td><s:iterator value="#mime.getRecipients(@javax.mail.Message$RecipientType@CC)">
					<span><s:property /></span>
				</s:iterator></td>
			</tr>
		</s:if>
		<tr>
			<td>Subject:</td>
			<td><s:property value="#mime.subject" /></td>
		</tr>
	</table>
	<s:push value="#mime">
		<div style="border-top: solid 2px black; margin: 10px 0; padding-bottom: 10px; background-color: #f0f0f0;"><s:include value="mime-part.jsp" /></div>
	</s:push>
</s:if>
</body>
</html>
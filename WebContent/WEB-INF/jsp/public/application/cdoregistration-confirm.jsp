<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>CDO Training Application Confirmation</title>
</head>
<body>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Applicant:</td>
			<td><s:property value="cdoApplication.title" /> <s:property value="cdoApplication.lastName" />, <s:property value="cdoApplication.firstName" /></td>
		</tr>
		<tr>
			<td>Applied for:</td>
			<td><s:property value="announcement.title" /> - <s:property value="announcement.type" /></td>
		</tr>

		<tr><td></td><td colspan="2"><div class="button-bar">Dear <s:property value="cdoApplication.title" /> <s:property value="cdoApplication.lastName" />, <s:property value="cdoApplication.firstName" />, <br/><br/>
		
		Your application has been submitted successfully. <br/> <br/>A copy of your application has been sent to your mailbox. <br/><br/> You will be contacted in due course if need be.<br/><br/>Thank you.<br/><br/>IITA Capacity Development Office<br/><br/></div></td></tr>
		<tr><td colspan="2"></td></tr>
		<tr><td colspan="2" align="left">For further information on this training please contact <a href="mailto:IITA-TrainingUnit@cgiar.org">IITA-TrainingUnit@cgiar.org</a>, or Lola Idowu (<a href="mailto:l.idowu@cgiar.org">l.idowu@cgiar.org</a>) on
08034035281/ext. 2894 & 2781
		</td></tr>
	</table>

</body>
</html>
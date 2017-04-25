<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>CDO Training Application Confirmation</title>
</head>
<body>
	<table class="inputform">
		<colgroup>
			<col width="10%" />
			<col />
		</colgroup>
		<tr>
			<td align="right">Applicant:</td>
			<td><s:property value="cdoBioData.title" /> <s:property value="cdoBioData.firstName" /> <s:property value="cdoBioData.lastName" /></td>
		</tr>
		<tr>
			<td align="right">Application for:</td>
			<td><s:property value="announcement.title" /> - <s:property value="announcement.type" /></td>
		</tr>

		<tr><td></td><td colspan="2"><div class="button-bar">Dear <s:property value="cdoBioData.title" /> <s:property value="cdoBioData.lastName" />, <s:property value="cdoBioData.firstName" />, <br/><br/>
		
		Your personal/biodata information has been submitted successfully and a user account created for your access to our Training Application Portal.
		<br/> <br/>A copy of your personal information submitted herein and a user account details have been sent to your mailbox. 
		<br/><br/>Click <a href="/training/login.jspx">HERE</a> to login and complete your application process.
		<br/><br/> You will be contacted in due course if need be.<br/><br/>Thank you.<br/><br/>IITA Capacity Development Office<br/><br/></div></td></tr>
		<tr><td colspan="2"></td></tr>
		<tr><td colspan="2" align="left">For further information on this training please contact <a href="mailto:IITA-TrainingUnit@cgiar.org">IITA-TrainingUnit@cgiar.org</a>, or Lola Idowu (<a href="mailto:l.idowu@cgiar.org">l.idowu@cgiar.org</a>) on
08034035281/ext. 2894 & 2781
		</td></tr>
	</table>

</body>
</html>
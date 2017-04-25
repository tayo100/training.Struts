<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>CDO Training Announcement Detail</title>
</head>
<body>
<div class="button-bar">
<s:form method="post" action="register" name="upRegister" id="upRegister">
<input type="hidden" name="projectId" value="<s:property value="project.id" />" />
<input type="submit" value="REGISTER NOW" />
</s:form>
</div>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Title:</td>
			<td><s:property value="project.trainingTitle" /></td>
		</tr>
		<tr>
			<td>Introduction/Background:</td>
			<td>
				<iita:text value="project.introduction" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Target group/participants:</td>
			<td>
				<iita:text value="project.targetGroup" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Expected No. of participants:</td>
			<td>
				<s:property value="project.numberOfParticipants" />
			</td>
		</tr>
		<tr>
			<td>Expected No. of female(s):</td>
			<td>
				<s:property value="project.numberOfFemale" />
			</td>
		</tr>
		<tr>
			<td>Expected No. of male(s):</td>
			<td>
				<s:property value="project.numberOfMale" />
			</td>
		</tr>
		<tr>
			<td>Objective:</td>
			<td>
				<iita:text value="project.objective" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Learning method:</td>
			<td>
				<iita:text value="project.learningMethod" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Expected outcome:</td>
			<td>
				<iita:text value="project.expectedOutcome" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Course contents:</td>
			<td>
				<iita:text value="project.courseContents" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Duration:</td>
			<td><s:property value="project.duration" /></td>
		</tr>
		
		<tr>
			<td>Location:</td>
			<td><s:property value="project.location" /></td>
		</tr>
		<tr>
			<td>Training fee:</td>
			<td>
				<iita:text value="project.trainingFee" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Accommodation:</td>
			<td>
				<iita:text value="project.accommodation" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Payment:</td>
			<td>
				<iita:text value="project.payment" maxLength="1500" />
			</td>
		</tr>
		<tr>
			<td>Application deadline:</td>
			<td><s:date format="%{getText('date.format')}" name="project.deadline" /></td>
		</tr>
		<tr><td colspan="2"><div class="button-bar">
<s:form method="post" action="register" name="btmRegister" id="btmRegister">
<input type="hidden" name="projectId" value="<s:property value="project.id" />" />
<input type="submit" value="REGISTER NOW" />
</s:form>
</div></td></tr>
		<tr><td colspan="2" align="left">For further information on this training please contact <a href="mailto:IITA-TrainingUnit@cgiar.org">IITA-TrainingUnit@cgiar.org</a>, or Lola Idowu (<a href="mailto:l.idowu@cgiar.org">l.idowu@cgiar.org</a>) on
08034035281/ext. 2894 &amp; 2781
		</td></tr>
	</table>
</body>
</html>
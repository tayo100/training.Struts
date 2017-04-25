<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>CDO Training Announcement Detail</title>
</head>
<body>
<table>
<colgroup><col width="80%" /><col width="20%" /></colgroup>
<tr>
<td style="vertical-align: top; padding-right: 30px">
<s:if test="user!=null">
	<s:set name="id" value="'announcementId'" />
	<s:set name="idValue" value="%{announcement.id}" />
</s:if>
<s:else>
	<s:set name="id" value="'announcementId'" />
	<s:set name="idValue" value="%{announcement.id}" />
</s:else>

<s:form method="post" action="register" name="upRegister" id="upRegister">

<input type="hidden" name="${id}" value="${idValue}" />

<div class="button-bar">
<s:submit value="REGISTER NOW" />
</div>

	<table class="inputform2">
		<colgroup>
			<col />
		</colgroup>
		<tr>
			<td align="left">
				<p>
					<strong>Title:</strong><br />
					<s:property value="announcement.type" />: <s:property value="announcement.title" />
				</p>
				<p>
					<strong>Introduction/Background:</strong><br />
					<iita:text value="announcement.introduction" maxLength="1500" />
				</p>
				<p>
					<strong>Target group/participants:</strong><br />
					<iita:text value="announcement.targetGroup" maxLength="1500" />
				</p>
				
				<p><strong>Expected No. of participants:</strong><br />
				<s:property value="announcement.numberOfParticipants" /></p>
				
				<p><strong>Expected No. of female(s):</strong><br />
				<s:property value="announcement.numberOfFemale" /></p>
			
				<p><strong>Expected No. of male(s):</strong><br />
				<s:property value="announcement.numberOfMale" /></p>
			
				<p><strong>Objective:</strong><br />
				<iita:text value="announcement.objective" maxLength="1500" /></p>
			
				<p><strong>Learning method:</strong><br />
				<iita:text value="announcement.learningMethod" maxLength="1500" /></p>
			
				<p><strong>Expected outcome:</strong><br />
				<iita:text value="announcement.expectedOutcome" maxLength="1500" /></p>
			
				<p><strong>Course contents:</strong><br />
				<iita:text value="announcement.courseContents" maxLength="1500" /></p>
			
				<p><strong>Training fee:</strong><br />
				<s:if test="announcement.trainingFee!=null">
						<s:text name="format.money">
							<s:param value="announcement.trainingFee" />
						</s:text> USD
					</s:if>
				</p>
				<p><strong>Accommodation:</strong><br />
				<iita:text value="announcement.accommodation" maxLength="1500" /></p>
			
				<p><strong>Payment information:</strong><br />
				<iita:text value="announcement.payment" maxLength="1500" /></p>
			
				<p><strong>Application deadline:</strong><br />
				<s:date format="%{getText('date.format')}" name="announcement.deadline" /></p>
				
				<p><strong>Location/Venue Information</strong><br />
					<s:if test="announcement.trainingLocations!=null">
						<s:if test="announcement.trainingLocations.size()>0">
							<div>
								<div>
								    <table class="inputform" id="locationTableList">
								    <colgroup>
										<col />
										<col />
										<col />
										<col />
										<col />
									</colgroup>
									<tr>
										<td>Country</td>
										<td>Location/Venue</td>
										<td>Started</td>
										<td>Ended</td>
										<td>Duration</td>
									</tr>
									<s:iterator value="announcement.trainingLocations" status="status">
										<s:set name="locIndex" value="#status.index" />
										<tr>
											<td><s:property value="country" /></td>
											<td><s:property value="venue" /></td>
							                <td><iita:date name="startDate" format="dd/MM/yyyy" /></td>
							                <td><iita:date name="endDate" format="dd/MM/yyyy" /></td>
							                <td><s:property value="duration" /></td>
							            </tr>
									</s:iterator>
								    </table>
								</div>
							</div>
						</s:if>
						<s:else>
							No location information found.
						</s:else>
					</s:if>
					<s:else>
						No location information found.
					</s:else>
					</p>
				</td>
			</tr>
		<tr><td colspan="2" align="right">
		<div class="button-bar">
<input type="submit" value="REGISTER NOW" />
</div>
</td></tr>
<tr><td colspan="2" align="left">For further information on this training please contact <a href="mailto:IITA-TrainingUnit@cgiar.org">IITA-TrainingUnit@cgiar.org</a>, or Lola Idowu (<a href="mailto:l.idowu@cgiar.org">l.idowu@cgiar.org</a>) on
08034035281/ext. 2894 & 2781
		</td></tr>
	</table>
</s:form>
</td>
<td>
<h2>Training Materials</h2>
<s:if test="announcement.documents.size()>0">
	<ul class="file-list">
		<s:iterator value="announcement.documents">
			<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-announcement-quick.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:else>
 <i>No information</i>
</s:else>
<p>&nbsp;</p>
<!-- Trainers -->
<h2>Resource Persons/Trainers</h2>
<s:if test="announcement.trainers.size()>0">
<s:set name="profile" value="announcement" />
<ul>
	<s:iterator value="announcement.trainers">
		<li><s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" /></li>
	</s:iterator>
</ul>
</s:if>
<s:else>
 <i>No information</i>
</s:else>
</td>
</tr>
</table>
</body>
</html>
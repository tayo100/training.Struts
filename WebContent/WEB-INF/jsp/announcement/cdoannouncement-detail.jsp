<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
<head>
<title>CDO Announcement Detail</title>

<script type="text/javascript">
	$(document).ready(function(){
		var bucks = {format: 'dd/mm/yyyy',
				autoclose: true,
				todayHighlight: true};
		$('input[name="startDate"]').datepicker(bucks);
		$('input[name="endDate"]').datepicker(bucks);
	});
</script>

</head>
<body>
<table>
	<colgroup>
		<col width="70%" />
		<col width="30%" />
	</colgroup>
	<tr>
		<td style="vertical-align: top; padding-right: 30px">
		<div class="button-bar">
			<a href="<s:url action="doupdate" />?id=<s:property value="id" />">Update</a>
			<a onclick="javascript: return window.confirm('Delete this entry?');"
				href="<s:url action="deleteannouncement" />?id=<s:property value="id" />">Delete</a>
			<a href="<s:url action="cdoindex" />">View List</a> 
			<a href="<s:url action="new-announcement" />">Add New</a>
		</div>

		<table class="inputform">
			<colgroup>
				<col width="20%" />
				<col />
			</colgroup>
			<tr>
				<td>Status:</td>
				<td><s:property value="announcement.status" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><s:property value="announcement.type" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><s:property value="announcement.title" /></td>
			</tr>
			<tr>
				<td>Introduction/Background:</td>
				<td><iita:text value="announcement.introduction"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Target group/participants:</td>
				<td><iita:text value="announcement.targetGroup"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Expected No. of participants:</td>
				<td><s:property value="announcement.numberOfParticipants" /></td>
			</tr>
			<tr>
				<td>Expected No. of female(s):</td>
				<td><s:property value="announcement.numberOfFemale" /></td>
			</tr>
			<tr>
				<td>Expected No. of male(s):</td>
				<td><s:property value="announcement.numberOfMale" /></td>
			</tr>
			<tr>
				<td>Objective:</td>
				<td><iita:text value="announcement.objective" maxLength="1500" />
				</td>
			</tr>
			<tr>
				<td>Learning method:</td>
				<td><iita:text value="announcement.learningMethod"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Expected outcome:</td>
				<td><iita:text value="announcement.expectedOutcome"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Course contents:</td>
				<td><iita:text value="announcement.courseContents"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Training fee:</td>
				<td><s:if test="announcement.trainingFee!=null">
						<s:text name="format.money">
							<s:param value="announcement.trainingFee" />
						</s:text> USD
					</s:if>
				</td>
			</tr>
			<tr>
				<td>Accommodation:</td>
				<td><iita:text value="announcement.accommodation"
					maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Payment:</td>
				<td><iita:text value="announcement.payment" maxLength="1500" />
				</td>
			</tr>
			<tr>
				<td>Application deadline:</td>
				<td><s:date format="%{getText('date.format')}"
					name="announcement.deadline" /></td>
			</tr>
			<tr>
				<td />
				<td>
					<h3>Location/Venue Information</h3>
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
							                <td><input name="startDate" type="text"> </td>
							                <td><input name="endDate" type="text"> </td>
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
				</td>
			</tr>
		</table>
		</td>
		<td>
		<h2>Training Materials</h2>
		<s:if test="announcement.documents!=null">
			<ul class="file-list">
				<s:iterator value="announcement.documents">
					<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-announcement-quick.jsp" /></li>
				</s:iterator>
			</ul>
		</s:if> <iita:authorize ifAnyGranted="ROLE_CRM">
			<p>Attach document/material to announcement:</p>
			<iita:fileupload action="announcement-document!upload"
				value="Upload files" queryParams="entityId=${announcement.id}" />
		</iita:authorize>
		<p>&nbsp;</p>
		<!-- Trainers -->
		<h2>Resource Persons/Trainers</h2>
		<iita:authorize ifAnyGranted="ROLE_CRM">
			<span id="trainerAdd_${id}">Add new trainer...</span>
			<iita:inlineeditor id="trainerAddNew" targetId="trainerAdd_${id}">
				<s:push value="announcement">
					<s:include value="/WEB-INF/jsp/trainer/trainingproposalquickform.jsp" />
				</s:push>
			</iita:inlineeditor>
			<s:set name="profile" value="announcement" />
			<ul>
				<s:iterator value="announcement.trainers">
					<li><s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" /></li>
				</s:iterator>
			</ul>
		</iita:authorize>
		<p>&nbsp;</p>
		<p><s:include
			value="/WEB-INF/jsp/announcement/cdoannouncement-tags.jsp" /></p>
		<h2>Tag cloud <small><a href="<s:url namespace="/" action="tag/cloud" />">Browse tag cloud</a></small></h2>
		<s:action namespace="/" name="tag/cloud!inline" executeResult="true" ignoreContextParams="true" />
		<p>&nbsp;</p>
		<p>
			For further information on this training please contact <a href="mailto:IITA-TrainingUnit@cgiar.org">IITA-TrainingUnit@cgiar.org</a>, or Lola Idowu (<a href="mailto:l.idowu@cgiar.org">l.idowu@cgiar.org</a>)
				on 08034035281/ext. 2894 & 2781
		</p>
	</tr>
</table>
</body>
</html>
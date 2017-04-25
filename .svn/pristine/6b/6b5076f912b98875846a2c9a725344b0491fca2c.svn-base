<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title><s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="program-navigation.jsp" %>

<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tr>
		<td>
		<h1><iita:text value="profile.title" />  <!-- <a href="<s:url action="program/remove" />?id=<s:property value="id" />"
	onclick="javascript: return confirm('Are you sure you want to remove this group training?');" title="Delete group training?" alt="Delete group training?" />[ X ]</a> --></h1>
		<table class="inputform" id="programProfile_%{id}">
			<colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td><label>Title:</label></td>
				<td><s:property value="profile.title" /></td>
			</tr>
			<tr>
				<td><label>Type:</label></td>
				<td><s:text name="trainingprogram.type.%{profile.status}" /></td>
			</tr>
			<tr>
				<td><label>Description:</label></td>
				<td><s:property value="profile.description" /></td>
			</tr>
			<!-- 
			<tr>
					<td><label>Program:</label></td>
					<td><s:property value="profile.program" /></td>
				</tr> -->
			<tr>
				<td><label>Female participants:</label></td>
				<td><s:property value="profile.femaleParticipants" /></td>
			</tr>
			<tr>
				<td><label>Male participants:</label></td>
				<td><s:property value="profile.maleParticipants" /></td>
			</tr>
			<tr>
				<td><label>Start date:</label></td>
				<td><s:date name="profile.startDate" format="dd/MM/yyyy" />, <s:date
					name="profile.startDate" nice="true" /></td>
			</tr>
			<tr>
				<td><label>End date:</label></td>
				<td><s:date name="profile.endDate" format="dd/MM/yyyy" />, <s:date
					name="profile.endDate" nice="true" /></td>
			</tr>
			<tr>
				<td><label>Duration:</label></td>
				<td><s:property value="profile.duration" /></td>
			</tr>
			<tr>
				<td><label>Location:</label></td>
				<td><s:property value="profile.location" /></td>
			</tr>
			<tr>
				<td><label>Longitude:</label></td>
				<td><s:property value="profile.longitude" /></td>
			</tr>
			<tr>
				<td><label>Latitude:</label></td>
				<td><s:property value="profile.latitude" /></td>
			</tr>
			<tr>
				<td><label>Country:</label></td>
				<td><s:property value="profile.country" /></td>
			</tr>
			<tr>
				<td><label>Outcomes:</label></td>
				<td><s:property value="profile.outcomes" /></td>
			</tr>
			<tr>
				<td><label>Purpose:</label></td>
				<td><s:property value="profile.pirpose" /></td>
			</tr>
			<tr>
				<td><label>CRPs</label></td>
				<td>
					<s:if test="profile.crps.size()>0">	
						<s:iterator value="profile.crps" status="status">
							<ul>
								<li><s:property value="name" /></li>
							</ul>
						</s:iterator>
					</s:if>
				</td>
			</tr>
			<tr>
				<td><label>Hubs</label></td>
				<td>
					<s:if test="profile.hubs.size()>0">	
						<s:iterator value="profile.hubs" status="status">
							<ul>
								<li><s:property value="name" /></li>
							</ul>
						</s:iterator>
					</s:if>
				</td>
			</tr>
			<tr>
				<td><label>Core Competencies</label></td>
				<td>
					<s:if test="profile.coreCompetencies.size()>0">	
						<s:iterator value="profile.coreCompetencies" status="status">
							<ul>
								<li><s:property value="name" /></li>
							</ul>
						</s:iterator>
					</s:if>
				</td>
			</tr>
			<tr>
				<td><label>Keywords:</label></td>
				<td><s:property value="profile.keywords" /></td>
			</tr>
			<s:if test="profile.expired">
				<tr>
					<td><label>Warning:</label></td>
					<td><b>The training program finished on <s:if
						test="profile.extensionDate!=null">
						<s:property value="profile.extensionDate" />, <s:date
							name="profile.extensionDate" nice="true" />
					</s:if><s:else>
						<s:property value="profile.endDate" />, <s:date
							name="profile.endDate" nice="true" />
					</s:else></b></td>
				</tr>
			</s:if>
			<tr>
				<td><label>Registered:</label></td>
				<td><fmt:formatDate value="${profile.createdDate}" type="both"
					pattern="dd/MM/yyyy" timeZone="${timeZone}" />, <s:date
					name="profile.createdDate" nice="true" /></td>
			</tr>
		</table>
		<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<h3><a href="<s:url action="program/remove" />?id=<s:property value="id" />"
	onclick="javascript: return confirm('Are you sure you want to remove this group training?');" title="Delete group training?" alt="Delete group training?" />Remove Group Training[ X ]</a></h3>
	
		<iita:inlineeditor id="profile_edit_program" targetId="programProfile_%{id}">
			<s:include value="form.jsp" />
		</iita:inlineeditor>
		</security:authorize>
		 <!-- Trainers -->
		<h2>Trainers</h2>
		<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<span id="programTrainer_${id}">Add new trainer...</span>
		<iita:inlineeditor id="trainer_addnew" targetId="programTrainer_${id}">
			<s:push value="profile">
				<s:include value="/WEB-INF/jsp/trainer/quickform.jsp" />
			</s:push>
		</iita:inlineeditor>
		</security:authorize>
		<ul>
			<s:iterator value="profile.trainers">
				<li><s:include value="/WEB-INF/jsp/trainer/group-small.jsp" /></li>
			</s:iterator>
		</ul>
		<h2>Funding</h2>
		<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<span id="programFunding_${id}">Add new funding...</span>
		<iita:inlineeditor id="" targetId="programFunding_${id}">
			<s:push value="profile">
				<s:include value="/WEB-INF/jsp/funding/form.jsp" />
			</s:push>
		</iita:inlineeditor>
		</security:authorize>
		<ul>
			<s:iterator value="profile.fundings">
				<li><s:include value="/WEB-INF/jsp/funding/small.jsp" /></li>
			</s:iterator>
		</ul>
		<h2>Alerts</h2>
		<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<span id="programAlert_${id}">Add new alert...</span>
		<iita:inlineeditor id="" targetId="programAlert_${id}">
			<s:push value="profile">
				<s:include value="/WEB-INF/jsp/alert/alert-form.jsp" />
			</s:push>
		</iita:inlineeditor>
		</security:authorize>
		<ul>
			<s:iterator value="profile.alerts">
				<li><s:include value="/WEB-INF/jsp/alert/small.jsp" /></li>
			</s:iterator>
		</ul>
		</td>
		<td>
		<h3>
			<s:if test="selectedTrainingProgram==true">
				<s:url id="removeUrl" namespace="/selection"
					action="selection!removeTrainingProgram">
					<s:param name="id" value="id" />
				</s:url>
				<s:a href="%{removeUrl}">Remove from Cart?</s:a>
			</s:if> <s:else>
				<s:url id="selectUrl" namespace="/selection"
					action="selection!addTrainingProgram">
					<s:param name="id" value="id" />
				</s:url>
				<s:a href="%{selectUrl}">Add to Cart?</s:a>
			</s:else>
			<s:form action="program/profile!postToLiferay" method="post">
			<s:hidden name="id" value="%{profile.id}"/>
			<s:submit  value="Post"/>
			</s:form>			
		</h3>

		<h2>Template files</h2>
		<ul class="file-list">
		<li class="file"><a href="<s:url action='program/download-xls?id=' /><s:property value="id" />">Download Excel Attendance Template</a></li>
		<li class="file"><a href="<s:url action='program/download-pdf?id=' /><s:property value="id" />">Download PDF Attendance Template</a></li>
		<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNIT,ROLE_QUERY,ROLE_QUERYMANAGER">
		<li class="file"><a href="<s:url action='xls/import?id=' /><s:property value="id" />">XLS Attendance Import</a></li>
		</security:authorize>
		</ul>
		<h2>Group files</h2>
		<s:if test="groupFiles!=null && groupFiles.size>0">
			<ul class="file-list">
				<s:iterator value="groupFiles">
					<li class="${file.directory?'directory':'file'}">
					<s:if test="file.directory">
						<a
							href="<s:url action="program/files" />?id=<s:property value="profile.id" />&directory=<s:property value="fileName" />"><s:property
							value="fileName" /></a> 
								<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNIT,ROLE_QUERY,ROLE_QUERYMANAGER">
									<a href="<s:url action="program/download-file!remove" />?id=<s:property value="profile.id" />&directory=<s:property value="fileName" />"
	onclick="javascript: return confirm('Delete document anyway?');" title="Delete document?" alt="Delete document?" />[ X ]</a>
								</security:authorize>
					</s:if> <s:else>
						<a
							href="<s:url action="program/download-file" />?id=<s:property value="profile.id" />&file=<s:property value="fileName" />"><s:property
							value="fileName" /></a> 
							<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNIT,ROLE_QUERY,ROLE_QUERYMANAGER">
								<a href="<s:url action="program/download-file!remove" />?id=<s:property value="profile.id" />&file=<s:property value="fileName" />"
	onclick="javascript: return confirm('Delete document anyway?');" title="Delete document?" alt="Delete document?" />[ X ]</a>
							</security:authorize>
					</s:else></li>
				</s:iterator>
			</ul>
		</s:if>
		<div><iita:fileupload action="program/upload-file"
			queryParams="id=${profile.id}" value="Upload file" /></div>
		
		<h2>Tags</h2>
		<ul class="taglist">
			<s:iterator value="profile.tags">
				<li><s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" /></li>
			</s:iterator>
			<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
				<li><span id="newProjectTag"><b>Add tag</b></span>
					<s:bean name="org.iita.trainingunit.model.TrainingProgramTag">
						<s:param name="entity" value="[1].profile" />
						<iita:inlineeditor id="" targetId="newProjectTag">
							<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
						</iita:inlineeditor>
					</s:bean></li>
			</iita:authorize>
		</ul>
		</td>
	</tr>
</table>
<s:push value="profile">
			<s:if test="attendance.size>0">
				<h2>Attendance List 
				<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
				<a href="<s:url action="program/removeAttendance" />?id=<s:property value="id" />"
	onclick="javascript: return confirm('Are you sure you want to remove this attendance list?');" title="Delete this list?" alt="Delete this list?" />[ X ]</a>
				</security:authorize>
				</h2>
				<s:include value="/WEB-INF/jsp/program/attendance-listing-short.jsp" />
			</s:if>
		</s:push>
</body>
</html>
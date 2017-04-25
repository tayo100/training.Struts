<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Trainee: <s:property value="profile.person.fullName" /></title>
</head>
<body>
<%@ include file="trainee-navigation.jsp" %>

<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">
			<h1><iita:text maxLength="60" value="profile.researchTopic" /></h1>

			<table class="inputform" id="traineeProfile_${id}">
				<colgroup>
					<col width="200px" />
					<col />
				</colgroup>
				<tr>
					<td><label>Trainee:</label></td>
					<td><s:push value="profile.person">
						<s:include value="/WEB-INF/jsp/person/small.jsp" />
					</s:push></td>
				</tr>
				<tr>
					<td><label>Topic:</label></td>
					<td><s:property value="profile.researchTopic" /></td>
				</tr>
				<tr>
					<td><label>Research Location:</label></td>
					<td><s:property value="profile.location" /></td>
				</tr>
				<!-- 
				<tr>
					<td><label>Longitude:</label></td>
					<td><s:property value="profile.longitude" /></td>
				</tr>
				<tr>
					<td><label>Latitude:</label></td>
					<td><s:property value="profile.latitude" /></td>
				</tr>
				 -->
				<tr>
					<td><label>Research Country:</label></td>
					<td><s:property value="profile.country" /></td>
				</tr>
				<tr>
					<td><label>Degree:</label></td>
					<td><s:text name="trainee.degree.%{profile.degree}" /></td>
				</tr>
				<tr>
					<td><label>Field of Study:</label></td>
					<td><s:property value="profile.discipline" /></td>
				</tr>
				<!-- 
				<tr>
					<td><label>Program:</label></td>
					<td><s:property value="profile.program" /></td>
				</tr>
				<tr>
					<td><label>Sub Programs</label></td>
					<td>
						<s:if test="profile.subPrograms.size()>0">	
							<s:iterator value="profile.subPrograms" status="status">
								<ul>
									<li><s:property value="name" /></li>
								</ul>
							</s:iterator>
						</s:if>
					</td>
				</tr>
				 -->
				<s:if test="profile.university!=null">
					<tr>
						<td><label>University:</label></td>
						<td><s:push value="profile.university">
							<s:include value="/WEB-INF/jsp/organization/quickinfo.jsp" />
						</s:push></td>
					</tr>
				</s:if>
				<tr>
					<td><label>Start date:</label></td>
					<td><fmt:formatDate value="${profile.startDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />,
					<s:date name="profile.startDate" nice="true" />
					</td>
				</tr>
				<tr>
					<td><label>End date:</label></td>
					<td><fmt:formatDate value="${profile.endDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />, 
					<s:date name="profile.endDate" nice="true" />
					</td>
				</tr>
				<s:if test="profile.extensionDate!=null">
					<tr>
						<td><label>Extension date:</label></td>
						<td><fmt:formatDate value="${profile.extensionDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />,
						<s:date name="profile.extensionDate" nice="true" />
						</td>
					</tr>
				</s:if>
				<tr>
					<td><label>Duration:</label></td>
					<td><s:property value="profile.duration" /></td>
				</tr>
				<tr>
					<td><label>Sponsor:</label></td>
					<td><s:property value="profile.sponsor" /></td>
				</tr>
				<s:if test="profile.expired">
					<tr>
						<td><label>Warning:</label></td>
						<td><b>The training expired on <s:if test="profile.extensionDate!=null">
							<s:property value="profile.extensionDate" />, <s:date name="profile.extensionDate" nice="true" />
						</s:if><s:else>
							<s:property value="profile.endDate" />, <s:date name="profile.endDate" nice="true" />
						</s:else></b></td>
					</tr>
				</s:if>
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
				<tr>
					<td><label>Registered:</label></td>
					<td><fmt:formatDate value="${profile.createdDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />,
					<s:date name="profile.createdDate" nice="true" />					
					</td>
				</tr>
			</table>

			<!-- Trainee -->
			<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<h3><a href="<s:url action="trainee/remove" />?id=<s:property value="id" />"
	onclick="javascript: return confirm('Are you sure you want to remove this trainee?');" title="Delete trainee?" alt="Delete trainee?" />Remove Trainee [ X ]</a></h3>
			<iita:inlineeditor  id="personeditform" targetId="traineeProfile_${id}">
				<s:push value="profile.person">
					<s:include value="/WEB-INF/jsp/trainee/editform.jsp" />
				</s:push>
			</iita:inlineeditor>
			</security:authorize> 
			<!-- Alumni -->
			<s:if test="alumni!=null">
			<s:push value="alumni">
			<h2>Alumnus info <a href="<s:url action="alumni/delete"/>?id=<s:property value="id" />&source=trainee&sourceId=<s:property value="profile.id" />" onclick="if(confirm('Delete alumni info anyway?')) return true; else return false;" title="Delete alumni info">[X]</a></h2>
				<ul>
					<li><s:include value="/WEB-INF/jsp/alumni/quickinfo.jsp" /></li>
				</ul>
			</s:push>
			</s:if>
			
			<!-- Trainers -->
			<h2>Supervisors</h2>
			<span id="supervisorAdd_${id}">Add new supervisor...</span>
			<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<iita:inlineeditor id="supervisorAddNew" targetId="supervisorAdd_${id}">
				<s:push value="profile">
					<s:include value="/WEB-INF/jsp/trainer/quickform.jsp" />
				</s:push>
			</iita:inlineeditor>
			</security:authorize>
			<ul>
				<s:iterator value="profile.supervisors">
					<li><s:include value="/WEB-INF/jsp/trainer/small.jsp" /></li>
				</s:iterator>
			</ul>
			
			<h2>Funding</h2>
			<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<span id="fundingAdd_${id}">Add new funding...</span>
			<iita:inlineeditor id="fundingAddNew" targetId="fundingAdd_${id}">
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
			<span id="alertAdd_${id}">Add new alert...</span>
			<iita:inlineeditor id="alertAddNew" targetId="alertAdd_${id}">
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


			<td style="padding-left: 10px;">
			<h3>
			<s:if test="selectedTrainee==true">
				<s:url id="removeUrl" namespace="/selection"
					action="selection!removeTrainee">
					<s:param name="id" value="id" />
				</s:url>
				<s:a href="%{removeUrl}">Remove from Cart?</s:a>
			</s:if> <s:else>
				<s:url id="selectUrl" namespace="/selection" action="selection!addTrainee">
					<s:param name="id" value="id" />
				</s:url>
				<s:a href="%{selectUrl}">Add to Cart?</s:a>
			</s:else>
			</h3>
			<s:push value="profile.person">
				<s:include value="/WEB-INF/jsp/person/contactinformation.jsp" />
			</s:push>

			<h2>Trainee files</h2>
			<s:if test="traineeFiles!=null && traineeFiles.size>0">
			<ul class="file-list">
				<s:iterator value="traineeFiles">
					<li class="${file.directory?'directory':'file'}">
					<s:if test="file.directory">
						<a href="<s:url action="trainee/files" />?id=<s:property value="profile.id" />&directory=<s:property value="fileName" />"><s:property value="fileName" /></a>
						<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNIT,ROLE_QUERY,ROLE_QUERYMANAGER">
							<a href="<s:url action="trainee/download-file!remove" />?id=<s:property value="profile.id" />&directory=<s:property value="fileName" />"
	onclick="javascript: return confirm('Delete document anyway?');" title="Delete document?" alt="Delete document?" />[ X ]</a>
						</security:authorize>
					</s:if>
					<s:else>
						<a href="<s:url action="trainee/download-file" />?id=<s:property value="profile.id" />&file=<s:property value="fileName" />"><s:property value="fileName" /></a>
						<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNIT,ROLE_QUERY,ROLE_QUERYMANAGER">
							<a href="<s:url action="trainee/download-file!remove" />?id=<s:property value="profile.id" />&file=<s:property value="fileName" />"
	onclick="javascript: return confirm('Delete document anyway?');" title="Delete document?" alt="Delete document?" />[ X ]</a>
						</security:authorize>
					</s:else></li>
				</s:iterator>
			</ul>
			</s:if>
			<div>
				<iita:fileupload action="trainee/upload-file" queryParams="id=${profile.id}" value="Upload file" />
			</div>
			
			<h2>Tags</h2>
			<ul class="taglist">
				<s:iterator value="profile.tags">
					<li><s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" /></li>
				</s:iterator>
				<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
					<li><span id="newTraineeTag"><b>Add tag</b></span>
						<s:bean name="org.iita.trainingunit.model.TraineeTag">
							<s:param name="entity" value="[1].profile" />
							<iita:inlineeditor id="" targetId="newTraineeTag">
								<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
							</iita:inlineeditor>
						</s:bean></li>
				</iita:authorize>
			</ul>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>
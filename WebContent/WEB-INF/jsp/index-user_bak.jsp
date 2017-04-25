<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Dashboard: <s:property value="user.fullName" /></title>
</head>
<body iita:help="promis/dashboard-user">
<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">
			<h1><s:property value="profile.legalName" /></h1>
			<table class="inputform">
				<colgroup>
					<col width="200px" />
					<col />
				</colgroup>
				<tr>
					<td><label>Last name:</label></td>
					<td><s:property value="profile.title" /> <s:property value="profile.lastName" /></td>
				</tr>
				<tr>
					<td><label>First name:</label></td>
					<td><s:property value="profile.firstName" /></td>
				</tr>
				<s:if test="profile.otherNames!=null">
					<tr>
						<td><label>Other names:</label></td>
						<td><s:property value="profile.otherNames" /></td>
					</tr>
				</s:if>
				<s:if test="profile.gender!=null">
					<tr>
						<td><label>Gender:</label></td>
						<td><s:text name="person.gender.%{profile.gender}" /></td>
					</tr>
				</s:if>
				<s:if test="profile.maritalStatus!=null">
					<tr>
						<td><label>Marital Status:</label></td>
						<td><s:text name="person.maritalStatus.%{profile.maritalStatus}" /></td>
					</tr>
				</s:if>
				<s:if test="profile.country!=null">
					<tr>
						<td><label>Country:</label></td>
						<td><s:property value="profile.country" /></td>
					</tr>
				</s:if>
				<s:if test="profile.dob">
					<tr>
						<td><label>Date of birth:</label></td>
						<td><fmt:formatDate value="${profile.dob}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" /></td>
					</tr>
				</s:if>
				<s:if test="profile.countryOfResidence!=null">
					<tr>
						<td><label>Country of Residence:</label></td>
						<td><s:property value="profile.countryOfResidence" /></td>
					</tr>
				</s:if>
				<s:if test="profile.user!=null">
					<tr>
						<td><label>ProMIS User:</label></td>
						<td><s:property value="profile.user.fullName" /> Log-in username: <b><s:property value="profile.user.userName" /></b> <s:if
							test="profile.user.lastLogin!=null">Last logged in <iita:date name="profile.user.lastLogin" format="dd/MM/yyyy" />
						</s:if> <s:else>Never logged in.</s:else></td>
					</tr>
				</s:if>
				<tr>
					<td><label>Registered:</label></td>
					<td><fmt:formatDate value="${profile.createdDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />, <s:date name="profile.createdDate"
						nice="true" /></td>
				</tr>
			</table>
			<!-- Affiliations -->
			<h2>Affiliations</h2>
			<ul>
				<s:iterator value="profile.affiliations">
					<li><%@ include file="/WEB-INF/jsp/person/affiliation.jsp"%></li>
				</s:iterator>
			</ul>
			</td>
			<td style="padding-left: 10px;"><s:if test="profile.lastAffiliation!=null">
				<h2>Last affiliation</h2>
				<s:push value="profile.lastAffiliation.organization">
					<s:include value="/WEB-INF/jsp/organization/quickinfo.jsp" />
				</s:push>
			</s:if>
			<s:if test="profile.contacts.size>0">
			<h2>Contact Information</h2>
			<s:iterator value="profile.contacts" status="status">
				<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
			</s:iterator>
			</s:if>
			
			<s:if test="user.accessTags.size()>0">
			<h2>Browse by tags</h2>
			<p>You have read access to all entities tagged with the following tags:</p>
			<ul>
			<s:iterator value="user.accessTags">
				<li><a title="Browse all entities with tag '${tag}'" href="<s:url action="tag/browse" />?tag=<s:property />"><s:property /></a></li>
			</s:iterator>
			</ul>			
			</s:if>			
			</td>
		</tr>
	</tbody>
</table>
<table style="width: 100%">
		<tr>
			<td>
<!-- Trainee -->
			<s:if test="trainees && trainees.size>0">
			<h2>Trainee in IITA</h2>
			<security:authorize ifAnyGranted="ROLE_TRAININGUNITHEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
			<span id="addTrainee_%{id}">Add new trainee...</span>
			<iita:inlineeditor id="" targetId="addTrainee_%{id}">
				<s:push value="profile">
					<s:include value="/WEB-INF/jsp/trainee/quickform.jsp" />
				</s:push>
			</iita:inlineeditor>
			</security:authorize>
			<ul>
			<s:iterator value="trainees">
				<li><s:include value="/WEB-INF/jsp/trainee/quickinfo.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<!-- Trainer -->
			<s:if test="supervisions && supervisions.size>0">
			<h2>Supervising a trainee</h2>
			<ul>
			<s:iterator value="supervisions">
				<li><s:include value="/WEB-INF/jsp/trainee/quickinfo-other.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<!-- Trainings conducted -->
			<s:if test="trainings && trainings.size>0">
			<h2>Trainer in training programs</h2>
			<ul>
			<s:iterator value="trainings">
				<li><s:include value="/WEB-INF/jsp/program/quickinfo.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<s:if test="similarPersons!=null && similarPersons.size>0">
			<h2>Similar persons</h2>
			<ul>
			<s:iterator value="similarPersons">
				<li>
				<a style="font-weight: bold; margin-right: 10px;" href="<s:url action="merge" />?left.className=org.iita.crm.model.Person&left.id=<s:property value="profile.id" />&right.className=org.iita.crm.model.Person&right.id=<s:property value="id" />">Merge</a>
				<%@include file="/WEB-INF/jsp/person/small.jsp" %>
				</li>
			</s:iterator>
			</ul>
			</s:if>

<s:if test="mail!=null && mail.size>0">
	<h2>Email correspondence</h2>
	<s:push value="mail">
		<s:include value="/WEB-INF/jsp/appmail/mail-list.jsp" />
	</s:push>
</s:if>
<security:authorize ifAnyGranted="ROLE_PARTNERADMIN">
	<h2>Register new partner</h2>
	<s:include value="/WEB-INF/jsp/partner/quickform.jsp" />
</security:authorize>
</td>
		</tr>
	</tbody>
</table>
</body>
</html>
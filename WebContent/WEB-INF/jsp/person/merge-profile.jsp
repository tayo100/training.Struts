<%@ include file="/common/taglibs.jsp"%>

<h1><s:property value="profile.legalName" /></h1>
<table class="inputform" id="personProfile_%{id}">
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
	<tr>
		<td><label>Gender:</label></td>
		<td><s:text name="person.gender.%{profile.gender}" /></td>
	</tr>
	<tr>
		<td><label>Marital Status:</label></td>
		<td><s:text name="person.maritalStatus.%{profile.maritalStatus}" /></td>
	</tr>
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

<!-- Contact info -->
<h2>Contact Information</h2>
<s:iterator value="contacts" status="status">
	<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
</s:iterator> 

<!-- Affiliations -->
<h2>Affiliations</h2>
<ul>
	<s:iterator value="profile.affiliations">
		<li><%@ include file="affiliation.jsp"%></li>
	</s:iterator>
</ul>

<!-- Trainee -->
<s:if test="trainees && trainees.size>0">
	<h2>Trainee in IITA</h2>
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
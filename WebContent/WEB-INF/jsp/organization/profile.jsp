<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title><s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="org-navigation.jsp" %>

<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">
<h1><s:property value="profile.title" /></h1>
<div id="organizationProfile_${id}">
<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Title:</label></td>
			<td><s:property value="profile.title" /></td>
		</tr>
		<%--<tr>
			<td><label>Type:</label></td>
			<td><s:text  name="organization.type.%{profile.type}" /></td>
		</tr>--%>
		<tr>
			<td><label>Short name:</label></td>
			<td><s:property value="profile.shortName" /></td>
		</tr>
		<s:if test="profile.parent!=null">
		<s:push value="profile.parent">
			<tr><td><label>Parent:</label></td><td><s:include value="small.jsp" /></td></tr>
		</s:push>
		</s:if>
		<s:if test="profile.subOrganizations!=null && profile.subOrganizations.size>0">
			<tr><td><label>Sub organizations:</label></td>
			<td><s:iterator value="profile.subOrganizations"><div><s:include value="small.jsp" /></div></s:iterator></td>
		</tr>
		</s:if>
	</table>
</div>

<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="organizationForm" targetId="organizationProfile_${id}">
<s:form method="post" action="organization/profile!update">
	<s:hidden name="id" value="%{profile.id}" />
	<s:hidden name="profile.version" value="%{profile.version}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Title:</label></td>
			<td><s:textfield name="profile.title" value="%{profile.title}" /></td>
		</tr>
		<%--	<tr>
			<td><label>Type:</label></td>
			<td><s:select name="profile.type" emptyOption="true" list="@org.iita.crm.model.Organization$OrganizationType@values()" listValue="%{getText('organization.type.' + toString())}" /></td>
		</tr> --%>
		<tr>
			<td><label>Short name:</label></td>
			<td><s:textfield name="profile.shortName" value="%{profile.shortName}" cssClass="numeric-input" /></td>
		</tr>
		<tr>
			<td><label>Parent:</label></td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="organization" name="profile.parent" id="aff.organizationId" listKey="id"
				listValue="fullTitle" url="%{xx}" method="autocompleteOrganization" submitTextTo="organizationName" value="%{profile.parent.id}" displayValue="%{profile.parent.fullTitle}" /></td>
		</tr>
		<tr>
			<td />
			<td><s:submit value="Update" /> <s:submit value="Delete" action="organization/profile!delete" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
</iita:inlineeditor>
</iita:authorize>

<h2>Affiliations</h2>
<span id="addAffiliation_${id}">Add affiliation...</span>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="personaffiliation" targetId="addAffiliation_${id}">
	<s:include value="affiliation-person-form.jsp" />
</iita:inlineeditor>
</iita:authorize>

<s:if test="profile.affiliations.size() <= 20">
<ul>
	<s:iterator value="profile.affiliations">
		<li><s:include value="affiliation.jsp" /></li>
	</s:iterator>
</ul>
</s:if>
<s:else>
	<p>Too many affiliations, <b><s:property value="profile.affiliations.size()" /></b> in total... Not listing.</p>
</s:else>


</td>
<td>
<h2>Contact Information</h2>
<s:iterator value="profile.contacts" status="status">
	<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
</s:iterator> 
<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/contact/add.jsp" />
</s:push>			
</iita:authorize>
</td>
</tr>
</tbody>
</table>


<s:if test="trainees!=null && trainees.size>0">
	<h2>Trainees</h2>
	<ul>
	<s:iterator value="trainees">
		<li><s:include value="/WEB-INF/jsp/trainee/quickinfo-other.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>

<h2>Documents</h2>
<s:if test="profile.documents!=null">
<ul class="file-list">
	<s:iterator value="profile.documents">
		<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-quick.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>

<s:if test="similarOrganizations!=null && similarOrganizations.size>0">
<h2>Similar organizations</h2>
<ul>
<s:iterator value="similarOrganizations">
	<li>
	<iita:authorize ifAnyGranted="ROLE_MERGE">
		<a style="font-weight: bold; margin-right: 10px;" href="<s:url action="merge" />?left.className=org.iita.crm.model.Organization&left.id=<s:property value="profile.id" />&right.className=org.iita.crm.model.Organization&right.id=<s:property value="id" />">Merge</a>
	</iita:authorize>
	<%@include file="/WEB-INF/jsp/organization/small.jsp" %>
	</li>
</s:iterator>
</ul>
</s:if>


<h2>Tags</h2>
<ul class="taglist">
	<s:iterator value="profile.tags">
		<li><s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" /></li>
	</s:iterator>
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<li><span id="newProjectTag"><b>Add tag</b></span> 
		<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<s:bean name="org.iita.crm.model.OrganizationTag">
				<s:param name="entity" value="[1].profile" />
				<iita:inlineeditor id="" targetId="newProjectTag">
					<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
				</iita:inlineeditor>
			</s:bean>
		</iita:authorize></li>
	</iita:authorize>
</ul>

</body>
</html>
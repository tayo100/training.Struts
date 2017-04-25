<%@ include file="/common/taglibs.jsp"%>

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
		<tr>
			<td><label>Type:</label></td>
			<td><s:text  name="organization.type.%{profile.type}" /></td>
		</tr>
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

<h2>Contact Information</h2>
<s:iterator value="profile.contacts" status="status">
	<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
</s:iterator> 

<h2>Affiliations</h2>
<ul>
	<s:iterator value="affiliations.results">
		<li><s:include value="affiliation.jsp" /></li>
	</s:iterator>
</ul>
<s:if test="affiliations.totalHits>affiliations.results.size()">
<p>There are <b><s:property value="affiliations.totalHits" /></b> affiliations in total...</p>
</s:if>


<h2>Agreements</h2>
<ul>
<s:iterator value="agreements.results">
	<li><s:include value="/WEB-INF/jsp/agreement/short.jsp" /></li>
</s:iterator>
</ul>
<s:if test="agreements.totalHits>agreements.results.size()">
<p>There are <b><s:property value="agreements.totalHits" /></b> agreements in total...</p>
</s:if>

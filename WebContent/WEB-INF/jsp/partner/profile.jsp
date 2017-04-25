<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>PARTNERSHIP: <s:property value="profile.title" /></title>
</head>
<body>
<%@ include file="partner-navigation.jsp" %>

<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">
<h1><s:property value="profile.title" /></h1>
<div id="partnerProfile_${id}">
<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Type:</label></td>
			<td><s:property value="profile.partnershipType" /></td>
		</tr>
		<tr>
			<td><label>Title:</label></td>
			<td><s:property value="profile.title" /></td>
		</tr>
		<tr>
			<td><label>Short name:</label></td>
			<td><s:property value="profile.shortName" /></td>
		</tr>
		<tr>
			<td><label>Department:</label></td>
			<td><s:property value="profile.department" /></td>
		</tr>
		<tr>
			<td><label>Agreement:</label></td>
			<td><iita:text value="profile.agreement" /></td>
		</tr>
		<tr>
			<td><label>Source File:</label></td>
			<td><s:property value="profile.sourceFile" /></td>
		</tr>
		<tr>
			<td><label>Source Person:</label></td>
			<td><s:property value="profile.sourcePerson" /></td>
		</tr>
		<tr>
			<td><label>Date Submitted:</label></td>
			<td>
			<fmt:formatDate value="${profile.dateSubmitted}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />,
					<s:date name="profile.dateSubmitted" nice="true" />
			</td>
		</tr>
		<tr>
			<td><label>Notes:</label></td>
			<td><iita:text value="profile.notes" /></td>
		</tr>
		<s:if test="profile.parent!=null">
		<s:push value="profile.parent">
			<tr><td><label>Parent:</label></td><td><s:include value="small.jsp" /></td></tr>
		</s:push>
		</s:if>
		<s:if test="profile.subPartners!=null && profile.subPartners.size>0">
			<tr><td><label>Sub Partners:</label></td>
			<td><s:iterator value="profile.subPartners"><div><s:include value="small.jsp" /></div></s:iterator></td>
		</tr>
		</s:if>
	</table>
</div>

<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
<iita:inlineeditor id="partnerForm" targetId="partnerProfile_${id}">
<s:form method="post" action="partner/profile!update">
	<s:hidden name="id" value="%{profile.id}" />
	<s:hidden name="profile.version" value="%{profile.version}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Type:</label></td>
			<td>
			<s:select name="profile.partnershipType" emptyOption="true" value="%{profile.partnershipType}" list="#{'DONOR':'DONOR','PARTNER':'PARTNER'}" /></td>
		</tr>
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
			<td><s:textfield name="profile.shortName" value="%{profile.shortName}" /></td>
		</tr>
		<tr>
			<td><label>Department:</label></td>
			<td><s:textfield name="profile.department" value="%{profile.department}" /></td>
		</tr>
		<tr>
			<td><label>Agreement:</label></td>
			<td><s:textarea name="profile.agreement" value="%{profile.agreement}" /></td>
		</tr>
		<tr>
			<td><label>Source File:</label></td>
			<td><s:textfield name="profile.sourceFile" value="%{profile.sourceFile}" /></td>
		</tr>
		<tr>
			<td><label>Source Person:</label></td>
			<td><s:textfield name="profile.sourcePerson" value="%{profile.sourcePerson}" /></td>
		</tr>
		<tr>
			<td><label>Date Submitted:</label></td>
			<td><iita:datepicker name="profile.dateSubmitted" value="%{profile.dateSubmitted}" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><label>Notes:</label></td>
			<td><s:textarea name="profile.notes" value="%{profile.notes}" /></td>
		</tr>
		<tr>
			<td><label>Parent:</label></td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="partner" name="profile.parent" id="aff.partnerId" listKey="id"
				listValue="fullTitle" url="%{xx}" method="autocompletePartner" submitTextTo="partnerName" value="%{profile.parent.id}" displayValue="%{profile.parent.fullTitle}" /></td>
		</tr>
		<tr>
			<td />
			<td><s:submit value="Update" /> <s:submit value="Delete" action="partner/profile!delete" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
</iita:inlineeditor>
</iita:authorize>

<table style="width: 100%">
		<colgroup>
			<col width="50%" />
			<col width="50%" />
		</colgroup>
		<tr>
		<td>
<h2>Associates</h2>
<span id="addAffiliation_${id}">Add associates...</span>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLEADMIN">
<iita:inlineeditor id="personaffiliation" targetId="addAffiliation_${id}">
	<s:include value="affiliation-person-form.jsp" />
</iita:inlineeditor>
</iita:authorize>

<s:if test="profile.partnerContacts.size() > 0">
<ul>
	<s:iterator value="profile.partnerContacts">
		<li><s:include value="affiliation.jsp" /></li>
	</s:iterator>
</ul>
</s:if>
<s:else>
	<p>No associates, <b><s:property value="profile.partnerContacts.size()" /></b> in total... Not listing.</p>
</s:else>
</td>
<td>
<h2>IITA Hub</h2>
<s:if test="profile.iitaHubs.size()>0">
<ul>
<s:iterator value="profile.iitaHubs" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/iitahub.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/iitahub_add.jsp" />
</s:push>			
</iita:authorize>
</td>
</tr>
</table>

<table style="width: 100%">
		<colgroup>
			<col width="50%" />
			<col width="50%" />
		</colgroup>
		<tr>
		<td>
<h2>Classifications</h2>
<s:if test="profile.classifications.size()>0">
<ul>
<s:iterator value="profile.classifications" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/classficiation.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/classficiation_add.jsp" />
</s:push>			
</iita:authorize>

<h2>Categories</h2>
<s:if test="profile.partnerCategories.size()>0">
<ul>
<s:iterator value="profile.partnerCategories" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/category.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/category_add.jsp" />
</s:push>			
</iita:authorize>

<h2>Core Businesses</h2>
<s:if test="profile.coreBusinesses.size()>0">
<ul>
<s:iterator value="profile.coreBusinesses" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/corebusiness.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/corebusiness_add.jsp" />
</s:push>			
</iita:authorize>

<h2>Mandate Crops</h2>
<s:if test="profile.mandateCrops.size()>0">
<ul>
<s:iterator value="profile.mandateCrops" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/mandatecrop.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/mandatecrop_add.jsp" />
</s:push>			
</iita:authorize>
</td>
<td>
<h2>Classification Sectors</h2>
<s:if test="profile.sectors.size()>0">
<ul>
<s:iterator value="profile.sectors" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/sector.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/sector_add.jsp" />
</s:push>			
</iita:authorize>



<h2>Classification Sub-Sectors</h2>
<s:if test="profile.subsectors.size()>0">
<ul>
<s:iterator value="profile.subsectors" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/subsector.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/subsector_add.jsp" />
</s:push>			
</iita:authorize>



<h2>Category Scales</h2>
<s:if test="profile.scales.size()>0">
<ul>
<s:iterator value="profile.scales" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/scale.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/scale_add.jsp" />
</s:push>			
</iita:authorize>

<h2>Core Business Categories</h2>
<s:if test="profile.coreBusinessCategories.size()>0">
<ul>
<s:iterator value="profile.coreBusinessCategories" status="status">
	<li><s:include value="/WEB-INF/jsp/partner/corebusinesscategory.jsp" /></li>
</s:iterator>
</ul>
</s:if>
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/partner/corebusinesscategory_add.jsp" />
</s:push>			
</iita:authorize>
</td>
</tr>
</table>
	
</td>
<td>
<h2>Contact Information</h2>
<s:iterator value="profile.contacts" status="status">
	<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
</s:iterator> 
<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
<s:push value="profile">		
	<s:include value="/WEB-INF/jsp/contact/add.jsp" />
</s:push>			
</iita:authorize>
</td>
</tr>
</tbody>
</table>

<table style="width: 100%">
<tr>
<td>
<h2>Documents</h2>
<s:if test="profile.documents!=null">
<ul class="file-list">
	<s:iterator value="profile.documents">
		<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-quick.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>

<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
	<p>Attach document to partner:</p>
	<iita:fileupload action="partner/document!upload" value="Upload files" queryParams="entityId=${profile.id}" />
</iita:authorize>


<s:if test="similarPartners!=null && similarPartners.size>0">
<iita:authorize ifAnyGranted="ROLE_CRM">
<h2>Similar partners</h2>
<ul>
<s:iterator value="similarPartners">
	<li>
		<a style="font-weight: bold; margin-right: 10px;" href="<s:url action="merge" />?left.className=org.iita.crm.model.Partner&left.id=<s:property value="profile.id" />&right.className=org.iita.crm.model.Partner&right.id=<s:property value="id" />">Merge</a>
		<%@include file="/WEB-INF/jsp/partner/small.jsp" %>
	</li>
</s:iterator>
</ul>
</iita:authorize>
</s:if>


<h2>Tags</h2>
<ul class="taglist">
	<s:iterator value="profile.tags">
		<li><s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" /></li>
	</s:iterator>
	<iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
		<li><span id="newProjectTag"><b>Add tag</b></span> <iita:authorize ifAnyGranted="ROLE_PARTNERADMIN">
			<s:bean name="org.iita.crm.model.PartnerTag">
				<s:param name="entity" value="[1].profile" />
				<iita:inlineeditor id="" targetId="newProjectTag">
					<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
				</iita:inlineeditor>
			</s:bean>
		</iita:authorize></li>
	</iita:authorize>
</ul>
</td>
</tr>
</tbody>
</table>
</body>
</html>
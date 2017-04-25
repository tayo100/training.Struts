<%@ include file="/common/taglibs.jsp"%>

<html lang="en">
<head>
    <title>Training Applications</title>
</head>
<body>

<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>

<s:if test="paged.totalHits > 0">
<table class="data-listing">
	<colgroup>
		<col width="2%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
		<col width="15%" />
		<col width="10%" />
		<col width="10%" />
		<col width="15%" />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>#</td>
			<td>Reg. Date</td>
			<td>Last Name</td>
			<td>First Name</td>
			<td>Address</td>
			<td>Country</td>
			<td>Status</td>
			<td>Requester</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property value="signedOn" /></td>
				<td><s:property value="biodata.lastName" /></td>
				<td><s:property value="biodata.firstName" /></td>
				<td><s:property value="biodata.permanentAddress" /></td>
				<td><s:property value="biodata.nationality" /></td>
				<td><s:property value="status" /></td>
				<td>			
					<s:if test="announcement!=null">	
						<s:property value="announcement.requester.fullName" />
					</s:if>
					<s:else>
						<em>Self</em>
					</s:else>
				</td>
				<td>
					<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					<%-- 
					<s:if test="%{top instanceof org.iita.trainingunit.applications.model.GroupTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:if>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.NonDegreeTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?nondegreeId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.OtherTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?otherId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.IndividualTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?individualId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.SabbaticalTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?sabbaticalId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.InHouseTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?inhouseGroupId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.StaffDevTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?staffDevId=<s:property value="id" />">View</a> | <a href="<s:url namespace="/announcement" action="application-process" />?applicationId=<s:property value="id" />">Process</a>
					</s:elseif> --%>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</s:if>
<s:else>
	<p>No applications have been submitted</p>
</s:else>
</body>
</html>
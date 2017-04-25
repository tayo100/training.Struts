<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/years.jsp"%>
			
<s:if test="pagedTrainee.pageSize > 0">
	
<s:include value="/WEB-INF/jsp/paging-year.jsp">
	<s:param name="page" value="pagedTrainee.page" />
	<s:param name="pages" value="pagedTrainee.pages" />
	<s:param name="pageSize" value="pagedTrainee.pageSize" />
	<s:param name="href" value="%{''}" />
	<s:param name="scope" value="scope" />
	<s:param name="year" value="year" />
</s:include>
<div style="padding: 2px 2px 3px 5px; background-color: rgb(239, 239, 239);">
	<s:form method="get" action="trainees/yearlyexport" namespace="/">
		<s:hidden name="exportyear" value="%{year}" /> 
	<s:submit value="Export to Excel" />
</s:form></div>
	<table class="data-listing table-striped">
		<colgroup>
			<col width="2%" />
			<col width="7%" />
			<col />
			<col />
			<col />
			<col width="7%" />
			<col width="10%" />
			<col width="12%" />
			<col width="7%" />
			<col width="7%" />
			<col width="7%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Location</td>
				<td>Nationality</td>
				<td>Research Topic</td>
				<td>Sponsor</td>
				<td>Supervisor(s)</td>
				<td>University</td>
				<td>Start Date</td>
				<td>End Date</td>
				<td>Extension</td>
				<td>Last Updated</td>
			</tr>
		</thead>
		<s:iterator value="pagedTrainee.results" status="status">
			<tr>
				<td><s:property value="#status.count + pagedTrainee.startAt" /></td>
				<td><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />"><s:property value="person.fullName" /></a></td>
				<td><s:property value="location" /></td>
				<td><s:property value="country" /></td>
				<td><s:property value="researchTopic" /></td>
				<td><s:property value="sponsor" /></td>
				<td>
					<s:iterator value="supervisors">
						<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
					</s:iterator>
				</td>
				<td><s:if test="university.title != null"><s:property value="university.title" /></s:if><s:else><s:property value="university.shortName" /></s:else>
				</td>
				<td><s:date format="%{getText('date.format')}" name="startDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="endDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="extensionDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="lastUpdated" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:if test="pagedTrainee.totalHits==0 && table.equals('Trainee')">
	<em>No trainee records found!</em>
</s:if>

<s:if test="pagedPrograms.pageSize > 0">
<s:include value="/WEB-INF/jsp/paging-year.jsp">
	<s:param name="page" value="pagedPrograms.page" />
	<s:param name="pages" value="pagedPrograms.pages" />
	<s:param name="pageSize" value="pagedPrograms.pageSize" />
	<s:param name="href" value="%{''}" />
	<s:param name="scope" value="scope" />
	<s:param name="year" value="year" />
</s:include>
<div style="padding: 2px 2px 3px 5px; background-color: rgb(239, 239, 239);">
	<s:form method="get" action="programs/yearlyexport" namespace="/">
		<s:hidden name="exportyear" value="%{year}" /> 
	<s:submit value="Export to Excel" />
</s:form></div>
		<table class="data-listing">
				<colgroup>
					<col width="2%" />
					<col />
					<col />
					<col />
					<col width="7%" />
					<col width="7%" />
					<col width="7%" />
					<col width="7%" />
					<col width="5%" />
				</colgroup>
				<thead>
				<tr>
					<td>#</td>
					<td>Title</td>
					<td>Trainers</td>
					<td>Program</td>
					<td>Location/Ctry</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Extension</td>
					<td>Updated</td>
				</tr>
				</thead>
				<s:iterator value="pagedPrograms.results" status="status">
				<tr>
					<td><s:property value="#status.count + pagedPrograms.startAt" /></td>
					<td><a href="<s:url action="program/profile" />?id=<s:property value="id" />"><s:property value="title" />, <s:property value="location" /></a></td>
					<td>
						<s:iterator value="trainers">
							<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
						</s:iterator>
					</td>
					<td><s:property value="program" /></td>
					<td><s:property value="country" /></td>
					<td><s:date format="%{getText('date.format')}" name="startDate" /></td>
					<td><s:date format="%{getText('date.format')}" name="endDate" /></td>
					<td><s:date format="%{getText('date.format')}" name="extensionDate" /></td>
					<td><s:date format="%{getText('date.format')}" name="lastUpdated" /></td>
				</tr>
				</s:iterator>
			</table>
</s:if>
<s:if test="pagedPrograms.totalHits==0 && table.equals('TrainingProgram')">
	<em>No training program records found!</em>
</s:if>

<s:if test="pagedOrg.pageSize > 0">
<s:include value="/WEB-INF/jsp/paging-year.jsp">
	<s:param name="page" value="pagedOrg.page" />
	<s:param name="pages" value="pagedOrg.pages" />
	<s:param name="pageSize" value="pagedOrg.pageSize" />
	<s:param name="href" value="%{''}" />
	<s:param name="scope" value="scope" />
	<s:param name="year" value="year" />
</s:include>
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col />
			<col width="7%" />
			<col width="10%" />
			<col width="7%" />
			<col width="13%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
			<td>#</td>
			<td>Organization</td>
			<td>Type</td>
			<td>Country</td>
			<td>Email</td>
			<td>Address</td>
			<td>Phone</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pagedOrg.results" status="status">
				<tr>
					<td><s:property value="#status.count + pagedOrg.startAt" /></td>
					<td><a href="<s:url action="organization/profile" />?id=<s:property value="id" />"><s:if test="shortName!=null"><s:property value="shortName" />: </s:if><s:property value="title" /></a></td>
					<td><s:property value="type" /></td>
					<td>
						<s:iterator value="contacts">
							<s:if test="top instanceof org.iita.crm.model.AddressContact">
								<s:property value="country" />; 
							</s:if>
						</s:iterator>						
					</td>
					<td>
						<s:iterator value="contacts">
							<s:if test="top instanceof org.iita.crm.model.EmailContact">
								<s:property value="email" />; 
							</s:if>
						</s:iterator>
					</td> 
					<td>
						<s:iterator value="contacts">
							<s:if test="top instanceof org.iita.crm.model.AddressContact">
								<s:property value="address" />, <s:property value="contacts.city" />, <s:property value="contacts.state" />; 
							</s:if>
						</s:iterator>
					</td>
					<td>
						<s:iterator value="contacts">
							<s:if test="top instanceof org.iita.crm.model.PhoneContact">
								<s:property value="phone" />; 
							</s:if>
						</s:iterator>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:if test="pagedOrg.totalHits==0 && table.equals('Organization')">
	<em>No organization records found!</em>
</s:if>

<s:if test="pagedTrainer.pageSize > 0">
<s:include value="/WEB-INF/jsp/paging-year.jsp">
	<s:param name="page" value="pagedTrainer.page" />
	<s:param name="pages" value="pagedTrainer.pages" />
	<s:param name="pageSize" value="pagedTrainer.pageSize" />
	<s:param name="href" value="%{''}" />
	<s:param name="scope" value="scope" />
	<s:param name="year" value="year" />
</s:include>
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col />
			<col />
			<col width="10%" />
			<col />
			<col width="13%" />
			<col width="10%" />
			<col width="7%" />
			<col width="7%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
			<td>#</td>
			<td>Name</td>
			<td>Training type</td>
			<td>Trainer type</td>
			<td>Notes</td>
			<td>Affiliation</td>
			<td>Country</td>
			<td>Email</td>
			<td>Address</td>
			<td>Phone</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pagedTrainer.results" status="status">
				<tr>
					<td><s:property value="#status.count + pagedTrainer.startAt" /></td>
					<td><a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a></td>
					<td><s:if test="trainee!=null"><a href="<s:url action="trainee/profile" />?id=<s:property value="trainee.id" />">Trainee: <s:property value="trainee.researchTopic" /></a></s:if><s:elseif test="group!=null"><a href="<s:url action="program/profile" />?id=<s:property value="group.id" />">Group: <s:property value="group.title" /></a></s:elseif><s:else>Unspecified</s:else></td>
					<td><s:property value="type" /></td>
					<td><s:property value="notes" /></td>
					<td><s:if test="lastAffiliation.organization.shortName!=null"><a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.shortName" /></a></s:if><s:elseif test="lastAffiliation.organization.title!=null"><a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.title" /></a></s:elseif><s:else>Unspecified</s:else></td>
					<td><s:property value="country" /></td>
					<td><s:property value="lastEmail.email" /></td>
					<td><s:property value="lastAddress.address" /></td>
					<td><s:property value="lastPhone.phone" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:if test="pagedTrainer.totalHits==0 && table.equals('Trainer')">
	<em>No trainer records found!</em>
</s:if>

<s:if test="pagedProposals.totalHits > 0">

<s:include value="/WEB-INF/jsp/paging-year.jsp">
	<s:param name="page" value="pagedProposals.page" />
	<s:param name="pages" value="pagedProposals.pages" />
	<s:param name="pageSize" value="pagedProposals.pageSize" />
	<s:param name="href" value="%{''}" />
	<s:param name="scope" value="scope" />
	<s:param name="year" value="year" />
</s:include>
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="10%" />
			<col />
			<col width="18%" />
			<col width="18%" />
			<col width="15%" />
			<col width="7%" />
			<col width="15%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Requester</td>
				<td>Title</td>
				<td>Project Information</td>
				<td>Activity</td>
				<td>Locations</td>
				<td>Trainers</td>
				<td>Documents</td>
			</tr>
		</thead>
		<s:iterator value="pagedProposals.results" status="status">
			<tr>
				<td><s:property value="#status.count + pagedProposals.startAt" /></td>
				<td><s:property	value="requester.fullName" /></td>
				<td>
					<strong><s:property	value="status" />:</strong> 
					<s:if test="title!=null">
						<a href="<s:url action="announcement/trainingproposal-details" />?id=<s:property value="id" />"><iita:text value="title" maxLength="500" /></a>
					</s:if>
				</td>
				<td><s:if test="projectInformation!=null">
						<iita:text value="projectInformation" maxLength="150" removeHTML="true" addDots="true" />
					</s:if>
				</td>
				<td><s:if test="activity!=null">
						<iita:text value="activity" maxLength="150" removeHTML="true" addDots="true" />
					</s:if>
				</td>
				<td>
				<s:if test="trainingLocations!=null">
						<s:iterator value="trainingLocations">
							<strong>-</strong><s:property value="venue" />, <s:property value="country" /> <s:date format="%{getText('date.format')}"
							name="startDate" />-<s:date format="%{getText('date.format')}" name="endDate" /> <strong>(<s:property value="duration" />)</strong>
						</s:iterator>
					</s:if>
					<s:else>
						No locations information found.
					</s:else>
				</td>
				<td>
					<s:if test="trainers!=null">
						<s:iterator value="trainers">
							<strong>-</strong><s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" /><br />
						</s:iterator>
					</s:if>
					<s:else>
						No trainer information found.
					</s:else>
				</td>
				<td>
					<s:if test="documents!=null">
						<s:iterator value="documents">
							<strong>-</strong><a href="<s:url action="announcement/document-download" />?id=<s:property value="top.id" />&file=<s:property value="document.filePath" />" target="_blank"><s:property value="document.filePath" /></a><br />
						</s:iterator>
					</s:if>
					<s:else>
						No documents information found.
					</s:else>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:if test="pagedProposals.totalHits==0 && table.equals('TrainingProposal')">
	<em>No records available from training proposals!</em>
</s:if>
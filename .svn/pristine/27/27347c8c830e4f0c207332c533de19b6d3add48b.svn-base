<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Indexing</title>
<s:if test="indexer.running">
	<meta http-equiv="Refresh" content="5;url=<s:url action="lucene/reindex" />" />
</s:if>
</head>
<body>
<s:if test="indexer.running">
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td>Indexer status:</td>
				<td><s:property value="indexer.status" /></td>
			</tr>
			<tr>
				<td>Table:</td>
				<td><s:property value="indexer.indexingTable" /></td>
			</tr>
			<tr>
				<td>Progress:</td>
				<td><s:property value="indexer.currentLot" />/<s:property value="indexer.totalLotCount" /></td>
			</tr>
			<tr>
				<td>Complete:</td>
				<td><b><s:property value="100*indexer.currentLot/indexer.totalLotCount" />%</b></td>
			</tr>
			<tr>
				<td />
				<td><s:form action="lucene/reindex!stop" method="POST">
					<s:submit value="Stop" />
				</s:form></td>
			</tr>
		</tbody>
	</table>
	<p>This status page will automatically refresh every 5 seconds.</p>
</s:if>
<s:else>
	<span iita:helptoc="tools/lucene">
	<s:form action="lucene/reindex!reindex" method="POST" theme="simple">
		<label>Scope:</label>

		<s:checkboxlist list="#{'org.iita.crm.model.Contact':'Contact information','org.iita.crm.model.OrganizationDocument':'Organization documents','org.iita.crm.model.Person':'Person','org.iita.trainingunit.model.Trainee':'Trainee','org.iita.crm.model.Organization':'Organization','org.iita.trainingunit.model.TrainingProgram':'Training programs','org.iita.crm.model.PartnerDocument':'Partnership documents','org.iita.crm.model.Partner':'Partnership','org.iita.trainingunit.announcements.model.TrainingProposal':'Training Proposals','org.iita.trainingunit.announcements.model.Announcement':'Announcements','org.iita.crm.model.AnnouncementDocument':'Announcement Documents','org.iita.crm.model.TrainingProposalDocument':'Training Proposal Documents'}" name="tables" value="%{indexer.indexTable}" label="Scope" />
		<s:submit value="Reindex" />
	</s:form></span>
</s:else>
</body>
</html>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Staff Development Training Application</title>
</head>
<body>
<s:if test="application!=null">
<s:push value="application">
<table style="width: 100%">
	<colgroup>
		<col />
		<s:if test="biodata!=null || cdoBioData!=null || application.documents!=null">
			<col width="350" />
		</s:if>
	</colgroup>
	<tbody>
<tr>
	<td>
		<h2>Application for: <a href="<s:url namespace="/announcement" action="profile" />?id=<s:property value="announcement.id" />"><s:property value="announcement.type" /> - <s:property value="announcement.title" /></a></h2>
		
		<s:hidden name="announcementId" value="%{announcement.id}" />
		<s:hidden name="applicationId" value="%{application.id}" />
		<h3>Application Status: <em><s:text name="application.status.%{application.status}" /></em></h3>
		<div id="accordion">
			<s:include value="/WEB-INF/jsp/application/biodata-details.jsp" />
			<s:include value="/WEB-INF/jsp/application/cdoreg-related-details.jsp" />
			
			<s:if test="application.locations.size()>0">
				<table class="data-listing">
				    <colgroup>
						<col width="200px" />
						<col />
					</colgroup>
				   <tr>
				        <td></td>
				        <td>
							<h3>TRAINING LOCATIONS</h3>
							<div><em>Applicant's chosen training location(s)</em></div>
							<div>
								<div>
								    <table class="inputform" id="applicantLocTable">
								    <colgroup>
										<col width="20%" />
										<col width="30%" />
										<col />
									</colgroup>
									<tr>
										<td><strong>Country</strong></td>
										<td><strong>Venue</strong></td>
										<td><strong>Start - End Dates</strong></td>
									</tr>
									<s:iterator value="application.locations" status="status">
										<s:set name="locIndex" value="#status.index" />
										<s:set name="appLocId" value="id" />
										<tr>
											<td><s:property value="trainingLocation.country" /></td>
							                <td><s:property value="trainingLocation.venue" /></td>
							                <td><s:property value="trainingLocation.startDate" /> - <s:property value="trainingLocation.endDate" /> (<s:property value="trainingLocation.duration" />)</td>
							            </tr>
									</s:iterator>
								    </table>
								</div>
							</div>
						</td>
				    </tr>
				</table>
			</s:if>
			
		</div> 
	</td>
<s:if test="biodata!=null || cdoBioData!=null || application.documents!=null">
	<td style="padding-left: 10px;">
		<s:if test="application.documents.size>0">
			<h2>Application Supporting Documents</h2>
			<s:if test="application.documents!=null">
				<ul class="file-list">
					<s:iterator value="application.documents">
						<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-application-quick.jsp" /></li>
					</s:iterator>
				</ul>
			</s:if>
		</s:if>
		
		<s:if test="user==cdoBioData.user">
			<p>Attach document to application:</p>
			<iita:fileupload action="application-document-details!upload" value="Upload files" queryParams="entityId=${application.id}" />
		</s:if>
		
		<s:if test="application.reportdocuments.size>0">
			<h2>Reporting Documents</h2>
			<s:if test="application.reportdocuments!=null">
			<ul class="file-list">
				<s:iterator value="application.reportdocuments">
					<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicationreport-quick.jsp" /></li>
				</s:iterator>
			</ul>
			</s:if>
		</s:if>
		
		<s:if test="user==cdoBioData.user">
			<p>Attach report document to application:</p>
			<iita:fileupload action="application-reportdocument-details!upload" value="Upload files" queryParams="entityId=${application.id}" />
		</s:if>
		
		<s:if test="cdoBioData!=null && user==cdoBioData.user">
			<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
		</s:if>
	</td>
</s:if>
</tr>
</tbody>
</table>
</s:push>
</s:if>
</body>
</html>
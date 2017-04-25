<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Graduate Training Application</title>
</head>
<body>

<s:if test="application!=null">

<s:push value="application">
<table style="width: 100%">
	<colgroup>
		<col />
		<s:if test="cdoBioData!=null">
			<col width="350" />
		</s:if>
	</colgroup>
	<tbody>
	<tr>
	<td>
<h2>Application for: <a href="<s:url namespace="/announcement" action="profile" />?id=<s:property value="announcement.id" />"><s:property value="announcement.title" /></a></h2>

<s:hidden name="announcementId" value="%{announcement.id}" />
<s:hidden name="applicationId" value="%{application.id}" />
<h3>Application Status: <em><s:text name="application.status.%{application.status}" /></em></h3>
<div id="container-fluid">
<s:include value="/WEB-INF/jsp/include/biodata-details.jsp" />

<s:include value="/WEB-INF/jsp/include/projectsummary-details.jsp" />
<s:include value="/WEB-INF/jsp/include/timeschedule-details.jsp" />
<s:include value="/WEB-INF/jsp/include/milestone-details.jsp" />
<s:include value="/WEB-INF/jsp/include/supporttype-details.jsp" />

</div> 
</td>

<s:if test="biodata!=null || cdoBioData!=null || application.documents!=null">
	<td style="padding-left: 10px;">
		<h2>Application Supporting Documents</h2>
		<s:if test="application.documents!=null">
		<ul class="file-list">
			<s:iterator value="application.documents">
				<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-application-quick.jsp" /></li>
			</s:iterator>
		</ul>
		</s:if>
		<p>Attach document to application:</p>
		<iita:fileupload action="application-document-details!upload" value="Upload files" queryParams="entityId=${application.id}" />
		
		<h2>Reporting Documents</h2>
		<s:if test="application.reportdocuments!=null">
		<ul class="file-list">
			<s:iterator value="application.reportdocuments">
				<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicationreport-quick.jsp" /></li>
			</s:iterator>
		</ul>
		</s:if>
		<p>Attach report document to application:</p>
		<iita:fileupload action="application-reportdocument-details!upload" value="Upload files" queryParams="entityId=${application.id}" />
		
		<s:if test="cdoBioData!=null">
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
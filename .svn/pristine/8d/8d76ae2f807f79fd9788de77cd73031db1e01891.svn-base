<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Other Training Application</title>
</head>
<body>
<s:if test="cdoOtherApplication!=null">
<s:push value="cdoOtherApplication">
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
<h2>Application for: <s:property value="announcement.type" /> - <s:property value="announcement.title" /> training</h2>

<s:hidden name="announcementId" value="%{announcement.id}" />
<s:hidden name="otherId" value="%{cdoOtherApplication.id}" />
<div id="accordion">
<s:include value="/WEB-INF/jsp/application/biodata-details.jsp" />
<s:include value="/WEB-INF/jsp/application/cdoreg-related-details.jsp" />

<s:if test="cdoOtherApplication.locations.size()>0">
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
									<s:iterator value="cdoOtherApplication.locations" status="status">
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
<s:if test="cdoBioData!=null && user==cdoBioData.user">
	<td style="padding-left: 10px;">
		<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
	</td>
</s:if>
</tr>
</tbody>
</table>
</s:push>
</s:if>
</body>
</html>
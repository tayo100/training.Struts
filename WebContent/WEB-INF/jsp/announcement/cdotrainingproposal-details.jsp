<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
<head>
<title>Scientists Training Proposal Details - <s:property value="trainingProposal.title" /></title>
</head>
<body>
	<div class="button-bar">
		<a href="<s:url action="trainingproposal" />">Training Proposal</a> 
		<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED"><a href="<s:url action="trainingproposal-copy!copy" />?id=<s:property value="trainingProposal.id" />" onclick="javascript: return confirm('Make a copy of this proposal?');">MAKE A COPY OF THIS PROPOSAL?</a></s:if>
	</div>
	<table style="width: 100%">
		<colgroup>
			<col />
			<s:if test="trainingProposal.id!=null">
				<col width="30%" />
			</s:if>
		</colgroup>
		<tbody>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
				<table class="data-listing">
					<colgroup>
						<col width="20%" />
						<col />
					</colgroup>
					<tr>
						<td colspan="2" align="left"><h2>Training Proposal Background</h2></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td>
						<s:property value="trainingProposal.type" /></td>
					</tr>
					
					<tr>
						<td valign="top">Title:</td>
						<td>
							<s:property value="trainingProposal.title" />
						</td>
					</tr>
					
					<s:if test="trainingProposal.owner!=null">
						<tr>
							<td>Owner:</td>
							<td><s:property value="trainingProposal.owner.fullName" /></td>
						</tr>
					</s:if>
					
					<s:if test="trainingProposal.id!=null">
						<tr>
							<td>Status:</td>
							<td><s:property value="trainingProposal.status" /></td>
						</tr>
					</s:if>
					<tr>
						<td>Requester:</td>
						<td>
							<s:property value="trainingProposal.requester.fullName" /></td>
					</tr>
					<tr>
						<td>Unit:</td>
						<td><s:property value="trainingProposal.unit" />
						</td>
					</tr>
					<tr>
						<td>Program Director:</td>
						<td>
							<s:property value="trainingProposal.programDirector.fullName" />
						</td>
					</tr>
					
					<tr>
						<td>Project Information:</td>
						<td>
							<iita:text value="trainingProposal.projectInformation" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>CRP:</td>
						<td>
							<iita:text value="trainingProposal.crp" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Charge Cost Center:</td>
						<td><s:property	value="trainingProposal.costCenter" />
						</td>
					</tr>
					<tr>
						<td>Activity:</td>
						<td>
							<iita:text value="trainingProposal.activity" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					
					<tr>
						<td colspan="2" align="left"><h2>Training Proposal Information</h2></td>
					</tr>
					
					<tr>
						<td>Training Introduction/Background:</td>
						<td>
							<iita:text value="trainingProposal.introduction" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Target group/participants:</td>
						<td>
							<iita:text value="trainingProposal.targetGroup" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Expected No. of participants:</td>
						<td><s:property value="trainingProposal.numberOfParticipants" /></td>
					</tr>
					<tr>
						<td>Expected No. of female(s):</td>
						<td><s:property value="trainingProposal.numberOfFemale" /></td>
					</tr>
					<tr>
						<td>Expected No. of male(s):</td>
						<td><s:property value="trainingProposal.numberOfMale" /></td>
					</tr> 
					
					<tr>
						<td>Objective:</td>
						<td>
							<iita:text value="trainingProposal.objective" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Learning method:</td>
						<td>
							<iita:text value="trainingProposal.learningMethod" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					
					<tr>
						<td>Expected outcome:</td>
						<td>
							<iita:text value="trainingProposal.expectedOutcome" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Course contents:</td>
						<td>
							<iita:text value="trainingProposal.courseContents" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
				
					<tr>
						<td>Training fee:</td>
						<td>
							<s:if test="trainingProposal.trainingFee!=null">
								<s:text name="format.money">
									<s:param value="trainingProposal.trainingFee" />
								</s:text> USD
							</s:if>
						</td>
					</tr>
					
					<tr>
						<td>Accommodation:</td>
						<td>
							<iita:text value="trainingProposal.accommodation" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Payment:</td>
						<td>
							<iita:text value="trainingProposal.payment" maxLength="150000" removeHTML="false" addDots="true" />
						</td>
					</tr>
					<tr>
						<td>Application deadline:</td>
						<td><s:property value="trainingProposal.deadline" /></td>
					</tr>
				</table>
					<h2>Location/Venue Information</h2>
					<table class="inputform">
							    <colgroup>
									<col width="20%" />
									<col />
									<col />
									<col />
									<col />
									<col />
								</colgroup>
								<s:if test="trainingProposal.trainingLocations!=null">
									<tr>
										<td />
										<td>Country</td>
										<td>Venue/Location:</td>
										<td>Starts:</td>
										<td>Ends:</td>
										<td>Duration</td>
									</tr>
									<s:iterator value="trainingProposal.trainingLocations">
										<tr>
											<td></td>
											<td><s:property value="country" /></td>
											<td><s:property value="venue" /></td>
							                <td><s:property value="startDate" /></td>
							                <td><s:property value="endDate" /></td>
							                <td><s:property value="duration" /></td>
							            </tr>
									</s:iterator>
								</s:if>
								<s:else>
									<tr>
										<td colspan="5">
											No location information found.
										</td>
									</tr>
								</s:else>
					</table>
					<h2>Resource Persons/Trainers</h2>
					<table class="inputform">
						<colgroup>
							<col width="20%" />
							<col />
						</colgroup>
						<tbody>
						<tr>
							<td></td>
							<td>
								<s:if test="trainingProposal.trainers!=null">
									<s:iterator value="trainingProposal.trainers">
										<s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" />
									</s:iterator>
								</s:if>
								<s:else>
									No trainer information found.
								</s:else>
							</td>
						</tr>
						</tbody>
					</table>
		</td>
		<s:if test="trainingProposal.id!=null">
			<td style="vertical-align: top;">
				<h2>Training Materials</h2>
				<s:if test="trainingProposal.documents!=null">
					<ul class="file-list">
						<s:iterator value="trainingProposal.documents">
							<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-trainingproposal-quick.jsp" /></li>
						</s:iterator>
					</ul>
				</s:if> 
				<iita:authorize ifAnyGranted="ROLE_USER,ROLE_CRM">
					<p>Attach document/material:</p>
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@DRAFT">
						<iita:fileupload action="trainingproposaledit-document!upload"
						value="Upload files" queryParams="entityId=${trainingProposal.id}" />
					</s:if>
				</iita:authorize>
								
				<!-- Conversion to announcement -->
				<iita:authorize ifAnyGranted="ROLE_CRM">
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement==null">
						<s:form action="convert-proposal" method="post">
							<s:hidden name="id" value="%{trainingProposal.id}" />
							Comment:<br />
							<s:textarea name="comments" value="%{comment}" cols="30" rows="3" cssStyle="padding:3px;" /><br />
							<button class="button-success pure-button button-xlarge" onclick="javascript: return confirm('Approve anyway?');">
							    <i class="fa fa-cog"></i>
							    Approve?
							</button>
							<s:submit cssClass="button-error pure-button button-xlarge" onclick="javascript: confirm('Request for ammendment anyway?');" action="reject-proposal" value="Request for Ammendment?" />
						</s:form>
					</s:if>
					<s:elseif test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement!=null">
					<button class="pure-button pure-button-disabled button-warning button-xlarge">Training Proposal Announced!</button>
					</s:elseif>
				</iita:authorize>
				
				<s:if test="trainingProposal.actionLog!=null && trainingProposal.actionLog.size()>0">
					<h2 id="action-log">Action log</h2>
					<table class="data-listing">
						<colgroup>
							<col width="95px" />
							<col width="95px" />
							<col width="100px" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<td>Date</td>
								<td class="identifying">Action</td>
								<td>Who</td>
								<td>Comment</td>
							</tr>
						</thead>
						<s:iterator value="trainingProposal.actionLog" status="status">
							<tr>
								<td><s:property value="sysDate" /></td>
								<td class="identifying"><s:property value="action" /></td>
								<td><s:property value="username" /></td>
								<td><s:property value="comment" /></td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
			</td>
		</s:if>
	</tr>
	</tbody>
	</table>
</body>
</html>
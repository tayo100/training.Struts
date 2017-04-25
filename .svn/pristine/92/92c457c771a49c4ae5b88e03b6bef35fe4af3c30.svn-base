<%@ include file="/common/taglibs.jsp"%>

<h3>PROPOSED ACADEMIC PROGRAM</h3>
<div>
	<div>
	    <table class="inputform">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td><em>Type of Training:*</em></td>
			<td></td>
			<td><em>Degree:*</em></td>
		</tr>
		<tr>
			<td></td>
			<td><s:property value="application.trainingType" /></td>
			<td></td>
			<td><s:property value="application.degree" /></td>
		</tr>
		<tr>
			<td />
			<td colspan="3"><em>How did you hear about this course (if not advertised)?:</em></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3"><s:property value="application.channelOfAwareness" /></td>
		</tr>
		<tr>
			<td />
			<td><em>Present University:*</em></td>
			<td><em>Degree Sought:*</em></td>
			<td><em>Proposed Research Theme:*</em></td>
		</tr>
		<tr>
			<td></td>
			<td><s:property value="application.presentUniversity" /></td>
			<td><s:property value="application.degreeSought" /></td>
			<td><s:property value="application.proposedResearchTheme" /></td>
		</tr>
		<tr>
			<td />
			<td><em>University Supervisor/Advisers:*</em></td>
			<td><em>University Supervisor's Email:*</em></td>
			<td><em>Name of IITA Supervisors:*</em></td>
		</tr>
		<tr>
			<td></td>
			<td><s:property value="application.nameOfUniversitySupervisor" /></td>
			<td><s:property value="application.emailOfUniversitySupervisor" /></td>
			<td><s:property value="application.nameOfIITASupervisor" /></td>
		</tr>		
		
	    </table>
	    
	    <div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
				<col />
			</colgroup>
			<tr>
				<td />
				<td><em>Research Locations:</em></td>
				<td><em>Expected Duration:</em></td>
			</tr>
			<tr>
				<td></td>
				<td><s:property value="application.researchLocation" /></td>
				<td><s:property value="application.expectedDuration" /></td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col width="100px" />
				<col width="100px" />
				<col />
			</colgroup>
			<tr>
				<td />
				<td><em>Start Date:</em></td>
				<td><em>End Date:</em></td>
				<td />
			</tr>
			<tr>
				<td></td>
				<td><iita:date name="application.startDate" format="dd/MM/yyyy" /></td>
				<td><iita:date name="application.endDate" format="dd/MM/yyyy" /></td>
				<td></td>
			</tr>
		    </table>
		</div>
		
		<s:include value="/WEB-INF/jsp/include/degrees/languagespoken-details.jsp" />
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td><em>Support Required*</em></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<s:text name="graduatetraining.supporttype.%{application.typeOfSupport}" />
				</td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td><em>Funding Source*</em></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<s:property value="application.fundingSource" />
				</td>
			</tr>
		    </table>
		</div>
	</div>
</div>
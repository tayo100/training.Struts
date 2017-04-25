<%@ include file="/common/taglibs.jsp"%>
	<h2 id="action-log">APPROVALS (IITA Internal use only)</h2>
	<table class="table">
		<colgroup>
			<col width="15%" />
			<col />
		</colgroup>
		<tbody>
			<s:if test="application instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining">
				<tr>
					<td>Rating of the quality of proposal and applicant by Scientist/Project Manager</td>
					<td><s:text name="application.rating.%{application.internalApprovals.rating}" /></td>
				</tr>
			</s:if>
			<s:iterator value="application.internalApprovals.coreCompetencies" status="status">
				<s:include value="/WEB-INF/jsp/request/include/application-corecompetencies-details.jsp" />			
			</s:iterator>
			
			<s:iterator value="application.internalApprovals.crps" status="status">
				<s:include value="/WEB-INF/jsp/request/include/application-crps-details.jsp" />			
			</s:iterator>
			
			<s:iterator value="application.internalApprovals.hubs" status="status">
				<s:include value="/WEB-INF/jsp/request/include/application-hubs-details.jsp" />			
			</s:iterator>

			<tr>
				<td>Project</td>
				<td><s:property value="application.internalApprovals.project" /></td>
			</tr>
			<tr>
				<td>Core Budget</td>
				<td><s:property value="application.internalApprovals.coreBudget" /></td>
			</tr>
			<s:if test="application instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining">
				<tr>
					<td>Total Budget</td>
					<td><s:property value="application.internalApprovals.totalBudget" /></td>
				</tr>
			</s:if>
			<tr>
				<td>Project Officer</td>
				<td><s:property value="application.internalApprovals.projOfficer" /></td>
			</tr>

			<s:iterator value="application.internalApprovals.budgetCodes" status="status">
				<s:include value="/WEB-INF/jsp/request/include/application-budget-details.jsp" />
			</s:iterator>
			
			<s:if test="application instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining">
				<tr>
					<td>Remarks</td>
					<td><s:property value="application.internalApprovals.remarks" /></td>
				</tr>
			</s:if>
		</tbody>
	</table>
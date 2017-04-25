<%@ include file="/common/taglibs.jsp"%>
<h3>Application Status: <em><s:text name="application.status.%{application.status}" /></em></h3>

<s:if test="application.status!=@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@PENDING">
	<s:if test="application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@WAITING">
		<s:include value="budgetholder-form.jsp" />
	</s:if>
	<s:elseif test="application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@WAITINGFORCDO">
		<s:include value="approval-form.jsp" />
	</s:elseif>
	<s:elseif test="application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@WAITINGFORDIRECTOR">
		<s:include value="director-form.jsp" />
	</s:elseif>
	<h3>Budget Code</h3>
	<table class="data-listing">
		<thead>
			<tr>
				<td>BC</td>
				<td>Status</td>
				<td>Holder</td>
				<td>Next Approver</td>
			</tr>
		</thead>
		<s:iterator value="application.internalApprovals.budgetCodes" status="status">
			<tr>
				<td><s:property value="code" /></td>
				<td><s:property value="status" /></td>
				<td><s:property value="budgetHolder.fullName" /></td>
				<td><s:property value="nextApprover.fullName" /></td>
			</tr>
		</s:iterator>
	</table>
	
	<s:include value="/WEB-INF/jsp/include/application-actionlog.jsp" />
</s:if>
<s:else>
	<s:if test="application instanceof org.iita.trainingunit.applications.model.GroupTraining">
		<s:include value="/WEB-INF/jsp/review/include/cdogroup-processing-form.jsp" />
	</s:if>
	<s:elseif test="application instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining">
		<s:include value="/WEB-INF/jsp/review/include/cdo-processing-form.jsp" />
	</s:elseif>
	<s:elseif test="application instanceof org.iita.trainingunit.applications.model.SabbaticalTraining">
		<s:include value="/WEB-INF/jsp/review/include/cdosabbatical-processing-form.jsp" />
	</s:elseif>
	<s:elseif test="application instanceof org.iita.trainingunit.applications.model.InternshipTraining">
		<s:include value="/WEB-INF/jsp/review/include/cdointernship-processing-form.jsp" />
	</s:elseif>
</s:else>

<s:include value="/WEB-INF/jsp/request/include/application-head.jsp" />


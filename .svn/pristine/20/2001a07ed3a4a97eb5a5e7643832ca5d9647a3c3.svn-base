<%@ include file="/common/taglibs.jsp"%>

<s:iterator value="application.internalApprovals.budgetCodes">	
	<s:if test="(application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@WAITING 
	&& nextApprover.id==user.id 
	&& (status==@org.iita.trainingunit.applications.model.BCodeStatus@NEW || status==@org.iita.trainingunit.applications.model.BCodeStatus@WAITING)) 
	|| ((application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@WAITING || application.status==@org.iita.trainingunit.applications.model.Application$APPLICATIONSTATUS@NEW) 
	&& (user.hasRole('ROLE_CFO') && (user.id!=ta.lineManager.id)))">
		<s:include value="application-review-form.jsp" />
	</s:if>
</s:iterator>
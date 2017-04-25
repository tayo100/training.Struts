<%@ include file="/common/taglibs.jsp"%>

<div>
<h2><a href="<s:url namespace="/announcement" action="application-list" />?announcementId=<s:property value="announcement.id" />">Application</a> form processing: <s:property value="application.refNumber" /></h2>
<s:form action="cdointernalProcess!forward" method="POST"><!--  -->
	<s:hidden value="%{applicationId}" name="applicationId" />
	<table class="inputform">
		<colgroup>
			<col width="15%" />
			<col />
		</colgroup>
		<tbody>
			<s:iterator value="application.internalApprovals.coreCompetencies" status="status">
				<s:set name="compIndex" value="#status.index" />
				<s:include value="/WEB-INF/jsp/request/include/application-corecompetencies-form.jsp" id="newcompform" />			
			</s:iterator>
			
			<s:if test="application.internalApprovals.coreCompetencies!=null">
				<s:set name="compIndex" value="application.internalApprovals.coreCompetencies.size" />
			</s:if>
			<s:else>
				<s:set name="compIndex" value="0" />
			</s:else>
			<s:include value="/WEB-INF/jsp/request/include/application-corecompetencies-form.jsp" id="newcompform" />
			<tr>
				<td><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More +</a></td>
				<td />
			</tr>
			
			<s:iterator value="application.internalApprovals.crps" status="status">
				<s:set name="crpsIndex" value="#status.index" />
				<s:include value="/WEB-INF/jsp/request/include/application-crps-form.jsp" id="newcrpform" />			
			</s:iterator>

			<s:if test="application.internalApprovals.crps!=null">
				<s:set name="crpsIndex" value="application.internalApprovals.crps.size" />
			</s:if>
			<s:else>
				<s:set name="crpsIndex" value="0" />
			</s:else>
			<s:include value="/WEB-INF/jsp/request/include/application-crps-form.jsp" id="newbcrpform" />
			<tr>
				<td><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More +</a></td>
				<td />
			</tr>
			
			<s:iterator value="application.internalApprovals.hubs" status="status">
				<s:set name="hubsIndex" value="#status.index" />
				<s:include value="/WEB-INF/jsp/request/include/application-hubs-form.jsp" id="newhubform" />			
			</s:iterator>
			
			<s:if test="application.internalApprovals.hubs!=null">
				<s:set name="hubsIndex" value="application.internalApprovals.hubs.size" />
			</s:if>
			<s:else>
				<s:set name="hubsIndex" value="0" />
			</s:else>
			
			<s:include value="/WEB-INF/jsp/request/include/application-hubs-form.jsp" id="newbhubform" />
			<tr>
				<td><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More +</a></td>
				<td />
			</tr>

			<tr>
				<td>Project</td>
				<td><s:textfield name="internalApprovals.project" value="%{application.internalApprovals.project}" /></td>
			</tr>
			<tr>
				<td>Core Budget</td>
				<td><s:textfield name="internalApprovals.coreBudget" value="%{application.internalApprovals.coreBudget}" /></td>
			</tr>
			<tr>
				<td>Project Officer</td>
				<td><s:url namespace="/ajax" action="public-ajax" id="xxxx" /> <iita:autocompleter cssClass="person" name="internalApprovals.internalApprovals.projOfficer" id="projOfficer" listKey="fullName"
				listValue="fullName" url="%{xxxx}" method="autocompleteUser" submitTextTo="projOfficer" value="%{application.internalApprovals.projOfficer}" /></td>
			</tr>
			<tr class="help">
				<td />
				<td>
				<div class="table">List <b>all involved</b> budget codes. Click <b>More +</b> below to add more records. In case of externally funded travel, specify the
				budget code that will be used to cover the purchase of ticket. To <b>DELETE</b> a cost center, just empty the cost center field and save your TA.</div>
				</td>
			</tr>
			<s:iterator value="application.internalApprovals.budgetCodes" status="status">
				<s:set name="budgetIndex" value="#status.index" />
				<s:include value="/WEB-INF/jsp/request/include/application-budget-form.jsp" />
			</s:iterator>

			<s:if test="application.internalApprovals.budgetCodes!=null">
				<s:set name="budgetIndex" value="application.internalApprovals.budgetCodes.size" />
			</s:if>
			<s:else>
				<s:set name="budgetIndex" value="0" />
			</s:else>
			
			<s:include value="/WEB-INF/jsp/request/include/application-budget-form.jsp" id="newbudgetform" />
			<tr>
				<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More +</a></td>
				<td />
			</tr>
			<tr>
				<td />
				<td><s:hidden name="budgetCode" value="%{id}" /><s:submit value="FORWARD" /> <s:submit value="REJECT" action="cdointernalProcess/reject" /></td><!--  -->
			</tr>
		</tbody>
	</table>
</s:form></div>
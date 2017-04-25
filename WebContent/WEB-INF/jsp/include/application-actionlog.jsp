<%@ include file="/common/taglibs.jsp"%>


<s:include value="/WEB-INF/jsp/review/include/cdo-processing-details.jsp" />
	
<s:if test="application.actionLog!=null && application.actionLog.size>0">	
	<h3 id="action-log">Application Process Action(s)</h3>
	<table class="data-listing">
		<colgroup>
			<col width="100px" />
			<col width="150px" />
			<col width="200px" />
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
		<s:iterator value="application.actionLog" status="status">
			<tr>
				<td><s:property value="sysDate" /></td>
				<td class="identifying"><s:property value="action" /></td>
				<td><s:property value="username" /></td>
				<td><s:property value="comment" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
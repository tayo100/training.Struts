<%@ include file="/common/taglibs.jsp"%>

<table class="data-listing">
	<colgroup>
		<col width="100px" />
		<col width="100px" />
		<col width="150px" />
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
	<s:iterator value="recentActions" status="status">
		<tr class="ht">
			<td><s:property value="sysDate" /></td>
			<td class="identifying"><s:property value="action" /></td>
			<td><s:property value="username" /></td>
			<td><a href="<s:url namespace="/" action="view" />?id=<s:property value="travelAuthorization.id" />#action-log"><s:property value="comment" /></a></td>
		</tr>
	</s:iterator>
</table>
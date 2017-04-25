<%@ include file="/common/taglibs.jsp"%>

<s:if test="ta.actionLog!=null && ta.actionLog.size>0">
	<h2 id="action-log">Action log</h2>
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
		<s:iterator value="ta.actionLog" status="status">
			<tr>
				<td><s:property value="sysDate" /></td>
				<td class="identifying"><s:property value="action" /></td>
				<td><s:property value="username" /></td>
				<td><s:property value="comment" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
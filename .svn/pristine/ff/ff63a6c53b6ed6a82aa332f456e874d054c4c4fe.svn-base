<%@ include file="/common/taglibs.jsp"%>
<table class="data-listing">
	<colgroup>
		<col />
		<col />
		<col />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>Other Names</td>
			<td>Country</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="top" status="status">
			<tr>
				<td><s:property value="top[1]" /></td>
				<td><s:property value="top[2]" /></td>
				<td><s:property value="top[3]" /></td>
				<td><s:property value="top[7]" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<s:if test="#allXlsRowData.size==0">
	<p>No alumni have been filed</p>
</s:if>
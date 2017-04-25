<%@ include file="/common/taglibs.jsp"%>
<h3>Partner data Snapshot</h3>
<table class="data-listing">
	<colgroup>
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>Short Name</td>
			<td>Title</td>
			<td>Street/Address</td>
			<td>Postal Address</td>
			<td>City</td>
			<td>State</td>
			<td>Country</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="top" status="status">
			<tr>
				<td><s:property value="top[0]" /></td>
				<td><s:property value="top[1]" /></td>
				<td><s:property value="top[3]" /></td>
				<td><s:property value="top[4]" /></td>
				<td><s:property value="top[5]" /></td>
				<td><s:property value="top[6]" /></td>
				<td><s:property value="top[7]" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<s:if test="#allXlsRowData.size==0">
	<p>No partner have been filed</p>
</s:if>
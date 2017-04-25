<%@ include file="/common/taglibs.jsp"%>
<table class="data-listing">
	<colgroup>
		<col />
		<col />
		<col />
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
			<td>Organization</td>
			<td>LastName</td>
			<td>MiddleName</td>
			<td>FirstName</td>
			<td>Title</td>
			<td>Position</td>
			<td>Discipline</td>
			<td>Gender</td>
			<td>Email</td>
			<td>Telephone</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="top" status="status">
			<tr>
				<td><s:property value="top[0]" /></td>
				<td><s:property value="top[1]" /></td>
				<td><s:property value="top[2]" /></td>
				<td><s:property value="top[3]" /></td>
				<td><s:property value="top[4]" /></td>
				<td><s:property value="top[5]" /></td>
				<td><s:property value="top[6]" /></td>
				<td><s:property value="top[7]" /></td>
				<td><s:property value="top[8]" /></td>
				<td><s:property value="top[9]" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<s:if test="#allXlsRowData.size==0">
	<p>No partner contacts have been filed</p>
</s:if>
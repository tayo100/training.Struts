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
		<col width="20px" />
	</colgroup>
	<thead>
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>Gender</td>
			<td>Designation</td> 
			<td>Telephone</td>
			<td>Email</td>
			<td>Nationality</td>
			<td>Country of Residence</td>
			<td>Background</td>
			<td>Other</td>
			<td>Present</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="profile.attendance">
			<tr>
				<td><s:property value="lastName" /></td>
				<td><s:property value="firstName" /></td>
				<td><s:property value="gender" /></td>
				<td><s:property value="designation" /></td>
				<td><s:property value="phone" /></td>
				<td><a href="mailto:<s:property value="email" />"><s:property value="email" /></a></td>
				<td><s:property value="nationality" /></td>
				<td><s:property value="countryOfResidence" /></td>
				<td><s:property value="background" /></td>
				<td><s:property value="other" /></td>
				<td><s:property value="present" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
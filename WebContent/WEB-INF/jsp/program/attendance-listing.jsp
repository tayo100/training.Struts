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
		<col />
		<col />
		<col />
		<col width="20px" />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>Gender</td>
			<td>DOB</td>
			<td>Designation</td> 
			<td>Telephone</td>
			<td>Email</td>
			<td>Address</td>
			<td>Nationality</td>
			<td>Country of Residence</td>
			<td>Education</td>
			<td>Institute of Affiliation</td>
			<td>Other</td>
			<td>Present(True/False)</td>
			<td>Background</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="#attendance" status="status">
			<tr>
				<td><s:property value="lastName" /></td>
				<td><s:property value="firstName" /></td>
				<td><s:property value="gender" /></td>
				<td><s:date name="dob" format="dd/MM/yyyy" /></td>
				<td><s:property value="designation" /></td>
				<td><s:property value="phone" /></td>
				<td><a href="mailto:<s:property value="email" />"><s:property value="email" /></a></td>
				<td><s:property value="address" /></td>
				<td><s:property value="nationality" /></td>
				<td><s:property value="countryOfResidence" /></td>
				<td><s:property value="education" /></td>
				<td><s:property value="instituteAffiliation" /></td>
				<td><s:property value="other" /></td>
				<td><s:property value="present" /></td>
				<td><s:property value="background" /></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<s:if test="#attendance.size==0">
	<p>No attendance have been filed under this group training</p>
</s:if>
<%@ include file="/common/taglibs.jsp"%>
<s:if test="paged.totalHits > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="21%" />
			<col width="13%" />
			<col width="21%" />
			<col width="7%" />
			<col width="14%" />
			<col width="15%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Gender</td>
				<td>Marital Status</td>
				<td>DOB</td>
				<td>Nationality</td>
				<td>Country of Residence</td>
				<td>Last Updated</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a></td>
				<td><s:if test="person.gender!=null"><s:text name="person.gender.%{person.gender}" /></s:if></td>
				<td><s:if test="person.maritalStatus!=null"><s:text name="person.maritalStatus.%{person.maritalStatus}" /></s:if></td>
				<td><fmt:formatDate value="${person.dob}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" /></td>
				<td><s:property value="person.country" /></td>
				<td><s:property value="person.countryOfResidence" /></td>
				<td><s:date format="%{getText('date.format')}" name="lastUpdated" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available for alumni.</p>
</s:else>
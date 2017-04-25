<%@ include file="/common/taglibs.jsp"%>
<s:if test="cdoInternshipApplication.internshipWorkExperience.size>0">
<h2>Education and Experience</h2>
<div>
	<div>
	    <table id="internworkexpTable" class="table">
	    <colgroup>
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td>Work experience</td>
			<td>Name of institution</td>
			<td>Country</td>
			<td>Period (MM/YYYY)</td>
		</tr>
		<s:iterator value="cdoInternshipApplication.internshipWorkExperience" status="status">
			<s:set name="interneduIndex" value="#status.index" />
			<tr>
				<td><s:property value="workExperience" /></td>
				<td><s:property value="institution" /></td>
				<td><s:property value="country" /></td>
                <td><s:property value="periodMonthYear" /></td>
            </tr>
			<tr>
				<td colspan="2">Training Duration</td>
				<td>Start Date</td>
				<td>End Date</td>				
			</tr>
			<tr>
				<td colspan="2"><s:property value="duration" /></td>				
				<td><s:date format="dd/MM/yyyy" name="startDate" /></td>				
				<td><s:date format="dd/MM/yyyy" name="endDate" /></td>				
			</tr>
		</s:iterator>
	    </table>
	</div>
</div>
</s:if>
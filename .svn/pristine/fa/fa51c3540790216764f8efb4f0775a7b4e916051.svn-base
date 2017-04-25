<%@ include file="/common/taglibs.jsp"%>
<s:if test="biodata.educationAndTraining.size>0">
	<div>
	    <table class="table" id="educationTable">
	    <colgroup>
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td colspan="6">
				<h2>EDUCATION AND TRAINING</h2>
				<h3>Current Education and Training</h3>
			</td>
		</tr>
		<tr>
			<td>Name of institution (most recent)</td>
			<td>Country</td>
			<td>Major field of study</td>
			<td>Certification obtained</td>
			<td>Started (MM/YYYY)</td>
			<td>Ended (MM/YYYY)</td>
		</tr>
		<s:iterator value="biodata.educationAndTraining" status="status">
			<s:set name="eduIndex" value="#status.index" />
			<tr>
				<td><s:property value="nameOfInstitution" /></td>
				<td><s:property value="country" /></td>
				<td><s:property value="majorFieldOfStudy" /></td>
				<td><s:property value="certificateObtained" /></td>
                <td><s:property value="startMonthOfCertification" /></td>
                <td><s:property value="stopMonthOfCertification" /></td>
            </tr>
		</s:iterator>
	    </table>
	</div>
</s:if>
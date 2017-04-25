<%@ include file="/common/taglibs.jsp"%>

<h3>OTHER STUDIES AND TRAINING</h3>
<div>
	<div>
	    <table class="table" id="otherStudiesAndTrainingTable">
	    <colgroup>
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
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
                <td><s:property value="startMonthYearOfCertification" /></td>
                <td><s:property value="stopMonthYearOfCertification" /></td>
            </tr>
		</s:iterator>
	    </table>
	</div>
</div>
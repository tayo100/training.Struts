<%@ include file="/common/taglibs.jsp"%>

<s:if test="biodata.previousEducationAndTraining.size>0">
<div>
<h4>Previous Education and Training</h4>
	<div>
	    <table id="preveducationTable" class="table">
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
		<s:iterator value="biodata.previousEducationAndTraining" status="status">
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
</s:if>
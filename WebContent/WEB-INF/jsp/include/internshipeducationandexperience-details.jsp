<%@ include file="/common/taglibs.jsp"%>
<s:if test="cdoInternshipApplication.internshipEducationAndTraining.size>0">
<h2>Education and Experience</h2>
<div>
	<div>
	    <table id="interneducationTable" class="table">
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
			<td>Starting period of study (MM/YYYY)</td>
			<td>Ending period of study (MM/YYYY)</td>
			<td>Major field of study</td>
			<td>Degree obtained/in view</td>
			
		</tr>
		<s:iterator value="cdoInternshipApplication.internshipEducationAndTraining" status="status">
			<s:set name="interneduIndex" value="#status.index" />
			<tr>
				<td><s:property value="nameOfInstitution" /></td>
				<td><s:property value="country" /></td>
                <td><s:property value="startMonthYearOfCertification" /></td>
                <td><s:property value="stopMonthYearOfCertification" /></td>
				<td><s:property value="majorFieldOfStudy" /></td>
				<td><s:property value="certificateObtained" /></td>
            </tr>
		</s:iterator>
		<tr>
				<td colspan="6">
					Area of specialization:
					<br/> <s:property value="cdoInternshipApplication.areaOfSpecialization" />
				</td>				
			</tr>
			<tr>
				<td colspan="6">
					Why do you which to have your work experience in IITA?<br/>
					<s:property value="cdoInternshipApplication.whyInIITA" />
				</td>				
			</tr>
	    </table>
	</div>
</div>
</s:if>
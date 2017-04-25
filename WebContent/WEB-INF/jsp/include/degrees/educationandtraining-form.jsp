<%@ include file="/common/taglibs.jsp"%>

<h3>EDUCATIONAL &amp; TRAINING INFO</h3>
<div>
	<div>
	    <table class="inputform" id="educationTable">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Name of institution:</td>
			<td>Major field of study:</td>
			<td>Certification obtained:</td>
			<td>Started:</td>
			<td>Ended:</td>
		</tr>
		<s:iterator value="cdoApplication.biodata.educationAndTraining" status="status">
			<s:set name="eduIndex" value="#status.index" />
			<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.educationAndTraining[%{eduIndex}].nameOfInstitution" value="%{nameOfInstitution}" /></td>
				<td><s:select 
					name="cdoApplication.biodata.educationAndTraining[%{eduIndex}].majorFieldOfStudy" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{majorFieldOfStudy}" headerKey="" headerValue="--Select major field--" /></td>
				<td><s:select emptyOption="" 
					name="cdoApplication.biodata.educationAndTraining[%{eduIndex}].certificateObtained" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{certificateObtained}" headerKey="" headerValue="--Select certificate obtained--" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.educationAndTraining[%{eduIndex}].startMonthOfCertification" value="%{startMonthOfCertification}" cssClass="mthyrpicker" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.educationAndTraining[%{eduIndex}].stopMonthOfCertification" value="%{stopMonthOfCertification}" cssClass="mthyrpicker" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.educationAndTraining[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.educationAndTraining==null ? 0 : cdoApplication.biodata.educationAndTraining.size}].nameOfInstitution" value="" /></td>
				<td><s:select emptyOption="" 
					name="cdoApplication.biodata.educationAndTraining[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.educationAndTraining==null ? 0 : cdoApplication.biodata.educationAndTraining.size}].majorFieldOfStudy" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{majorFieldOfStudy}" headerKey="" headerValue="--Select major field--" /></td>
				<td><s:select
					name="cdoApplication.biodata.educationAndTraining[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.educationAndTraining==null ? 0 : cdoApplication.biodata.educationAndTraining.size}].certificateObtained" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{certificateObtained}" headerKey="" headerValue="--Select certificate obtained--" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.educationAndTraining[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.educationAndTraining==null ? 0 : cdoApplication.biodata.educationAndTraining.size}].startMonthOfCertification" value="" cssClass="mthyrpicker" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.educationAndTraining[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.educationAndTraining==null ? 0 : cdoApplication.biodata.educationAndTraining.size}].stopMonthOfCertification" value="" cssClass="mthyrpicker" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyEducation($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More educational info +</a></td>
			</tr>
	    </table>
	</div>
</div>
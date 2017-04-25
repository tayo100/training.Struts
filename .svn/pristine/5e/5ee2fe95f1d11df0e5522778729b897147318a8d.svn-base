<%@ include file="/common/taglibs.jsp"%>

<h3>OTHER STUDIES AND TRAINING</h3>
<div>
	<div>
	    <table id="educationTable" class="table">
	    <colgroup>
			<col width="15%" />
			<col width="15%" />
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Year (YYYY)</td>
			<td>Duration (in weeks)</td>
			<td>Place</td>
			<td>Topic</td>
		</tr>
		<s:iterator value="cdoBioData.otherStudiesAndTraining" status="status">
			<s:set name="eduIndex" value="#status.index" />
			<tr>
				<td><s:textfield name="cdoBioData.otherStudiesAndTraining[%{eduIndex}].year" value="%{year}" cssClass="mthyrpicker form-control" /></td>
				<td><s:textfield cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{eduIndex}].duration" value="%{duration}" /></td>
				<td><s:textfield cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{eduIndex}].place" value="%{place}" /></td>
				<td><s:textarea cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{eduIndex}].topic" value="%{topic}" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td><s:textfield name="cdoBioData.otherStudiesAndTraining[%{cdoBioData.otherStudiesAndTraining.size}].year" value="%{year}" cssClass="mthyrpicker form-control" /></td>
				<td><s:textfield cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{cdoBioData.otherStudiesAndTraining.size}].duration" value="%{duration}" /></td>
				<td><s:textfield cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{cdoBioData.otherStudiesAndTraining.size}].place" value="%{place}" /></td>
				<td><s:textarea cssClass="form-control" name="cdoBioData.otherStudiesAndTraining[%{cdoBioData.otherStudiesAndTraining.size}].topic" value="%{topic}" /></td>
           </tr>
			<tr>
				<td colspan="4"><a onclick="javascript: copyEducation($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More other studies and training info +</a></td>
			</tr>
	    </table>
	</div>
</div>
<%@ include file="/common/taglibs.jsp"%>

<h3>EMPLOYMENT HISTORY</h3>
<div>
	<div>
	    <table class="inputform" id="employmentTable">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Name of employer:</td>
			<td>Address of employer:</td>
			<td>Job title:</td>
			<td>Appointment:</td>
			<td>Exit:</td>
		</tr>
		<s:iterator value="cdoApplication.biodata.employmentHistory" status="status">
			<s:set name="empIndex" value="#status.index" />
			<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{empIndex}].nameOfEmployer" value="%{nameOfEmployer}" /></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{empIndex}].addressOfEmployer" value="%{addressOfEmployer}" /></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{empIndex}].jobTitle" value="%{jobTitle}" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.employmentHistory[%{empIndex}].appointedOn" value="%{appointedOn}" cssClass="datepicker" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.employmentHistory[%{empIndex}].exitedOn" value="%{exitedOn}" cssClass="datepicker" /></td>
			</tr>
		</s:iterator>
	       	<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].nameOfEmployer" value="" /></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].addressOfEmployer" value="" /></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].jobTitle" value="" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].appointedOn" value="" cssClass="datepicker" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].exitedOn" value="" cssClass="datepicker" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyEmployment($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More history +</a></td>
			</tr>
	    </table>
	</div>
</div>
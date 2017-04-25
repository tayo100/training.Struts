<%@ include file="/common/taglibs.jsp"%>

<h3>DESCRIBE JOB ROLES</h3>
<div>
	<div>
	    <table class="inputform" id="employmentTable">
	    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Brief Responsibilities:</td>
		</tr>
		<s:iterator value="cdoApplication.biodata.employmentHistory" status="status">
			<s:set name="empIndex" value="#status.index" />
			<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{empIndex}].nameOfEmployer" value="%{nameOfEmployer}" /></td>
			</tr>
		</s:iterator>
	       	<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.employmentHistory[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.employmentHistory==null ? 0 : cdoApplication.biodata.employmentHistory}].nameOfEmployer" value="" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyEmployment($($(this).parentNode.parentNode).previous(), 3, 0); return false;">Add more +</a></td>
			</tr>
	    </table>
	</div>
</div>
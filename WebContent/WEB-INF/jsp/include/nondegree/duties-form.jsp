<%@ include file="/common/taglibs.jsp"%>

<h3>MAJOR DUTIES & RESPONSIBILITIES (On your current job)</h3>
<div>
	<div>
	    <table class="inputform" id="dutiesTable">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>List briefly your major duties:</td>
			<td>List briefly your major responsibilties:</td>
		</tr>
		<s:iterator value="cdoNonDegreeApplication.majorDuties" status="status">
			<s:set name="dutyIndex" value="#status.index" />
			<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.majorDuties[%{dutyIndex}].duties" value="%{duties}" /></td>
				<td><s:textfield name="cdoNonDegreeApplication.majorDuties[%{dutyIndex}].responsibilities" value="%{responsibilities}" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.majorDuties[%{cdoNonDegreeApplication==null || cdoNonDegreeApplication.majorDuties==null ? 0 : cdoNonDegreeApplication.majorDuties.size}].duties" value="%{duties}" /></td>
				<td><s:textfield name="cdoNonDegreeApplication.majorDuties[%{cdoNonDegreeApplication==null || cdoNonDegreeApplication.majorDuties==null ? 0 : cdoNonDegreeApplication.majorDuties.size}].responsibilities" value="%{responsibilities}" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyDuty($($(this).parentNode.parentNode).previous(), 3, 0); return false;">Add more +</a></td>
			</tr>
	    </table>
	</div>
</div>